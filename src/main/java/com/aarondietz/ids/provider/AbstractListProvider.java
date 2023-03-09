package com.aarondietz.ids.provider;

import com.aarondietz.ids.FileUtil;
import com.aarondietz.ids.StringProvider;

import java.util.Deque;

abstract class AbstractListProvider implements StringProvider {
    private final String resourcePath;
    private final boolean shuffleContent;
    private final long totalContentSize;
    private Deque<String> availableContent;

    AbstractListProvider(String resourcePath, boolean shuffleContent) {
        this.resourcePath = resourcePath;
        this.shuffleContent = shuffleContent;

        reloadContent();
        totalContentSize = availableContent.size();
    }

    private void reloadContent() {
        availableContent = FileUtil.loadToArrayDequeWithouBlanks(resourcePath, shuffleContent);
    }

    @Override
    public synchronized String getContent() {
        if (availableContent.isEmpty()) {
            reloadContent();
        }

        return availableContent.getFirst();
    }

    @Override
    public long getTotalContentSize() {
        return totalContentSize;
    }

    @Override
    public long getLeftContentSize() {
        return availableContent.size();
    }
}
