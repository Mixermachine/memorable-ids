package com.a9d3.ids.phrase_provider;

import com.a9d3.ids.StringProvider;
import com.a9d3.ids.provider.AdjectiveProvider;
import com.a9d3.ids.provider.NumberProvider;
import com.a9d3.ids.provider.SafeAnimalProvider;

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
