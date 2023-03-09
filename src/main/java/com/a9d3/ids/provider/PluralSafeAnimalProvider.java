package com.a9d3.ids.provider;

public class PluralSafeAnimalProvider extends SafeAnimalProvider {
    public PluralSafeAnimalProvider(boolean shuffleContent) {
        super(shuffleContent);
    }

    @Override
    public String getContent() { //NOSONAR Parent implementation already synchronizes
        return super.getContent() + "s";
    }
}
