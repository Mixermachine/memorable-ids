package com.aarondietz.ids.provider;

public class HistoryHumanProvider extends AbstractListProvider {

    public HistoryHumanProvider(boolean shuffleContent) {
        super("historyHumans.txt", shuffleContent);
    }
}
