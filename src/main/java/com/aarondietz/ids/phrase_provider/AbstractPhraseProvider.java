package com.aarondietz.ids.phrase_provider;

import com.aarondietz.ids.StringProvider;

import java.util.Arrays;
import java.util.List;

abstract class AbstractPhraseProvider implements StringProvider {
    private final long size;
    private final List<StringProvider> stringProviders;

    AbstractPhraseProvider(StringProvider... stringProvidersArray) {
        this.stringProviders = Arrays.asList(stringProvidersArray);
        size = stringProviders.stream().map(StringProvider::getTotalContentSize).reduce(1L, (a, b) -> a * b);
    }

    @Override
    public String getContent() {
        // A bit faster then streams
        StringBuilder stringBuilder = new StringBuilder();
        stringProviders.forEach(stringProvider -> stringBuilder.append(stringProvider.getContent()));

        return stringBuilder.toString();
    }

    @Override
    public long getTotalContentSize() {
        return size;
    }

    @Override
    public long getLeftContentSize() {
        return stringProviders.stream().map(StringProvider::getTotalContentSize).reduce(0L, Long::sum);
    }
}
