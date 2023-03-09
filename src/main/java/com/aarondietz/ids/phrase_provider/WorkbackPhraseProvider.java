package com.aarondietz.ids.phrase_provider;

import com.aarondietz.ids.StringProvider;
import com.aarondietz.ids.provider.*;

/**
 * 70 lovely parrots fly busily
 * <a href="https://theworkback.com/6-sad-squid-snuggle-softly/">Blog post about this phrase</a>
 */
public class WorkbackPhraseProvider extends AbstractPhraseProvider {
    public WorkbackPhraseProvider(StringProvider joinStringProvider) {
        super(new NumberProvider(2, 100, true),
                joinStringProvider,
                new AdjectiveProvider(true),
                joinStringProvider,
                new PluralSafeAnimalProvider(true),
                joinStringProvider,
                new VerbProvider(true),
                joinStringProvider,
                new AdverbProvider(true)
        );
    }
}
