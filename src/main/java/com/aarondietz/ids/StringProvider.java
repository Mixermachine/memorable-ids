package com.aarondietz.ids;

public interface StringProvider {
    Object getContent();

    long getTotalContentSize();

    long getLeftContentSize();
}
