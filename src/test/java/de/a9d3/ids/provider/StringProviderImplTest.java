package de.a9d3.ids.provider;

import de.a9d3.ids.StringProvider;
import de.a9d3.ids.phrase_provider.HistoryHumanPhraseProvider;
import de.a9d3.ids.phrase_provider.SafeAnimalPhraseProvider;
import de.a9d3.ids.phrase_provider.WorkbackPhraseProvider;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringProviderImplTest {
    private static Map<String, StringProvider> stringProviders = new HashMap<>();

    public StringProviderImplTest() {
        stringProviders = Stream.of(
                new BlankProvider(),
                new DotProvider(),
                new HyphenProvider(),
                new HistoryHumanProvider(true),
                new SafeAnimalProvider(true),
                new NumberProvider(0, 100, true),
                new AdjectiveProvider(true),
                new VerbProvider(true),
                new AdverbProvider(true),
                new WorkbackPhraseProvider(new BlankProvider()),
                new HistoryHumanPhraseProvider(new BlankProvider()),
                new SafeAnimalPhraseProvider(new BlankProvider())
        ).collect(Collectors.toMap(civilizedHumansProvider -> civilizedHumansProvider.getClass().getSimpleName(),
                civilizedHumansProvider -> civilizedHumansProvider));
    }

    @Test
    void testAllImplementations() {
        stringProviders.forEach((name, stringProvider) -> {
            assertTrue(stringProvider.getTotalContentSize() > 0,
                    "Expected " + name + " to have more then 0 content");
            assertTrue(stringProvider.getLeftContentSize() > 0,
                    "Expected " + name + " to have more then 0 left content");
            assertNotNull(stringProvider.getContent(), "Expected " + name + " to have non null content");
        });
    }

    @Test
    void loadTest() {
        int iterations = 1000000;
        System.out.println("#########");

        stringProviders.forEach((name, stringProvider) -> {
            Instant beginInstant = Instant.now();
            IntStream.range(0, iterations).forEach(value -> assertNotNull(stringProvider.getContent()));

            System.out.println("Getting " + iterations + " strings from " + name + " took " +
                    Duration.between(beginInstant, Instant.now()).toMillis() + "ms");
        });
    }

    @Test
    void totalContentTest() {
        System.out.println("#########");
        stringProviders.entrySet().stream() // Sort by permutation size
                .sorted(Comparator.comparingLong(entry -> entry.getValue().getTotalContentSize()))
                .forEach(entry -> {
                    assertTrue(entry.getValue().getTotalContentSize() > 0);
                    System.out.printf("Provider " + entry.getKey() + " has %,d possible permutations\n",
                            entry.getValue().getTotalContentSize());
                });
    }
}