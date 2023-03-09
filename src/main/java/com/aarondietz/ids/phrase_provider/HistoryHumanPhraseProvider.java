package com.aarondietz.ids.phrase_provider;

import com.aarondietz.ids.StringProvider;
import com.aarondietz.ids.provider.AdjectiveProvider;
import com.aarondietz.ids.provider.HistoryHumanProvider;
import com.aarondietz.ids.provider.NumberProvider;

/**
 * pretty hermann 3
 */
public class HistoryHumanPhraseProvider extends AbstractPhraseProvider {
    public HistoryHumanPhraseProvider(StringProvider joinStringProvider) {
        super(new AdjectiveProvider(true),
                joinStringProvider,
                new HistoryHumanProvider(true),
                joinStringProvider,
                new NumberProvider(1, 100, true)
        );
    }
}
