package de.a9d3.ids.phrase_provider;

import de.a9d3.ids.StringProvider;
import de.a9d3.ids.provider.AdjectiveProvider;
import de.a9d3.ids.provider.NumberProvider;
import de.a9d3.ids.provider.SafeAnimalProvider;

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
