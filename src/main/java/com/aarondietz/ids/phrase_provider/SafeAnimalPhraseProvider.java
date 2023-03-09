package com.aarondietz.ids.phrase_provider;

import com.aarondietz.ids.StringProvider;
import com.aarondietz.ids.provider.AdjectiveProvider;
import com.aarondietz.ids.provider.NumberProvider;
import com.aarondietz.ids.provider.SafeAnimalProvider;

/**
 * brave chipmunk 53
 */
public class SafeAnimalPhraseProvider extends AbstractPhraseProvider {
    public SafeAnimalPhraseProvider(StringProvider joinStringProvider) {
        super(new AdjectiveProvider(true),
                joinStringProvider,
                new SafeAnimalProvider(true),
                joinStringProvider,
                new NumberProvider(1, 100, true));
    }
}
