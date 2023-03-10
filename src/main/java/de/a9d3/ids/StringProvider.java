package de.a9d3.ids;

public interface StringProvider {
    Object getContent();

    long getTotalContentSize();

    long getLeftContentSize();
}
