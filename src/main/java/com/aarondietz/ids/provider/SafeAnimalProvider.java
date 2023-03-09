package com.aarondietz.ids.provider;

public class SafeAnimalProvider extends AbstractListProvider {
    public SafeAnimalProvider(boolean shuffleContent) {
        super("safeAnimals.txt", shuffleContent);
    }
}
