package com.a9d3.ids.provider;

import com.a9d3.ids.StringProvider;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberProvider implements StringProvider {
    private static final SecureRandom secureRandom = new SecureRandom();

    private final int from;
    private final int to;
    private final boolean shuffleContent;

    private Deque<Integer> availableContent;

    public NumberProvider(int from, int to, boolean shuffleContent) {
        if (from >= to) {
            throw new IllegalArgumentException("To needs to be greater then from");
        }

        this.from = from;
        this.to = to;
        this.shuffleContent = shuffleContent;

        reloadContent();
    }

    private void reloadContent() {
        Stream<Integer> integerStream = IntStream.range(from, to).boxed();

        if (shuffleContent) {
            List<Integer> list = integerStream.collect(Collectors.toCollection(ArrayList::new));
            Collections.shuffle(list, secureRandom);
            availableContent = new ArrayDeque<>(list);
        } else {
            availableContent = integerStream.collect(Collectors.toCollection(ArrayDeque::new));
        }

    }

    @Override
    public synchronized String getContent() {
        if (availableContent.isEmpty()) {
            reloadContent();
        }

        return availableContent.getFirst().toString();
    }

    @Override
    public long getTotalContentSize() {
        return (to - from);
    }

    @Override
    public long getLeftContentSize() {
        return availableContent.size();
    }
}
