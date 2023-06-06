package de.a9d3.ids;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {
    private static final SecureRandom secureRandom = new SecureRandom();

    private FileUtil() {
        // Util class should not instantiated
    }

    public static Deque<String> loadToArrayDequeWithoutBlanks(String resourcePath, boolean shuffle) {
        try (InputStream data = FileUtil.class.getClassLoader().getResourceAsStream(resourcePath)) {
            assert data != null;
            Stream<String> stringStream = new BufferedReader(new InputStreamReader(data, StandardCharsets.UTF_8)).lines()
                    .filter(line -> !line.trim().startsWith("//"))
                    .filter(line -> !"".equals(line));

            if (shuffle) {
                ArrayList<String> list = stringStream.collect(Collectors.toCollection(ArrayList::new));
                Collections.shuffle(list, secureRandom);
                return new ArrayDeque<>(list);
            } else {
                return stringStream.collect(Collectors.toCollection(ArrayDeque::new));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + resourcePath, e); // NOSONAR This error will never be thrown because the resources and implementations are static
        }
    }
}
