package de.a9d3.ids.provider;

public class SafeAnimalProvider extends AbstractListProvider {
    public SafeAnimalProvider(boolean shuffleContent) {
        super("safeAnimals.txt", shuffleContent);
    }
}
