package de.a9d3.ids.provider;

import de.a9d3.ids.StringProvider;

public class BlankProvider implements StringProvider {
    @Override
    public String getContent() {
        return " ";
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
