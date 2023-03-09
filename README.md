# memorable-ids

Generate memorable/readable IDs in Java with ease.
All parts are design to be reusable and implement the StringProvider interface.
No external libraries (besides jUnit) are used and thus this library is pretty lightweight.

## Example

```java
import com.aarondietz.ids.phrase_provider.HistoryHumanPhraseProvider;
import com.aarondietz.ids.phrase_provider.SafeAnimalPhraseProvider;
import com.aarondietz.ids.phrase_provider.WorkbackPhraseProvider;
import com.aarondietz.ids.provider.BlankProvider;
import com.aarondietz.ids.provider.DotProvider;
import com.aarondietz.ids.provider.HyphenProvider;

public class MyTest {
    public static void main(String[] args) {
        StringProvider stringProvider = new WorkbackPhraseProvider(new HyphenProvider());
        stringProvider.getContent(); // 70-lovely-parrots-fly-busily
        stringProvider.getTotalContentSize(); // 20,451,072,768

        stringProvider = new SafeAnimalPhraseProvider(new BlankProvider());
        stringProvider.getContent(); // brave chipmunk 53
        stringProvider.getTotalContentSize(); // 2,870,208

        stringProvider = new HistoryHumanPhraseProvider(new DotProvider());
        stringProvider.getContent(); // pretty.hermann.3
        stringProvider.getTotalContentSize(); // 6,101,568
    }
}

```

## Phrase Providers

You can choose from multiple phrase providers or create your own.

### WorkbackPhraseProvider

Number(2,99) _ Adjective _ PluralSafeAnimal _ Verb _ Adverb -> 19-new-antelopes-travel-tightly

Inspired by the blog post from 2011: https://theworkback.com/6-sad-squid-snuggle-softly/

### SafeAnimalPhraseProvider

Adjective _ SafeAnimal _ Number (0,99) -> elastic-dolphin-69

I removed some animals from this list because they might spark discomfort in users.
When a customer has a problem with his device he does not really want read that his device is internaly named "
lazy-pig-23"...

### HistoryHumanPhraseProvider

Adjective _ HistoryHuman _ Number (0,99) -> funny-wilson-31

Historical figures

### Own implementation

```java
import com.aarondietz.ids.provider.AdjectiveProvider;
import com.aarondietz.ids.provider.NumberProvider;
import com.aarondietz.ids.provider.SafeAnimalProvider;

public class MyPhraseProvider extends AbstractPhraseProvider {
    public MyPhraseProvider(StringProvider joinStringProvider) {
        super(new AdjectiveProvider(true),
                joinStringProvider,
                new NumberProvider(0, 100, true),
                joinStringProvider,
                new SafeAnimalProvider(true)
        );
    }
}
```

## Performance

Tested on a laptop with i7-1165G7 without warmup:

```
Getting 1000000 strings from SafeAnimalPhraseProvider took 717ms
Getting 1000000 strings from HistoryHumanPhraseProvider took 479ms
Getting 1000000 strings from WorkbackPhraseProvider took 621ms
```

## References

This library is heavily inspired by https://github.com/kkuegler/human-readable-ids-java
I wanted to have more words and a more flexible design so I designed this library.