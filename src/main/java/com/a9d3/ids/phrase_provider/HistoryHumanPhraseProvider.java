package com.a9d3.ids.phrase_provider;

import com.a9d3.ids.StringProvider;
import com.a9d3.ids.provider.AdjectiveProvider;
import com.a9d3.ids.provider.HistoryHumanProvider;
import com.a9d3.ids.provider.NumberProvider;

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
