package com.a9d3.ids.provider;

import com.a9d3.ids.StringProvider;

public class HyphenProvider implements StringProvider {
    @Override
    public String getContent() {
        return "-";
    }

    @Override
    public long getTotalContentSize() {
        return 1;
    }

    @Override
    public long getLeftContentSize() {
        return 1;
    }
}
