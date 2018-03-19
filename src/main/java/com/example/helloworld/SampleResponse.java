package com.example.helloworld;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.math3.random.RandomDataGenerator;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SampleResponse {
    @JsonIgnore
    private int id;
    private String timestamp;
    private String uniqueId;
    private String shortDescription;
    private String longText;
    private double randomDouble;

    SampleResponse() {
        this.id = generateRandomInteger();
        this.timestamp = getTimestamp();
        this.uniqueId = generateUUID();
        this.randomDouble = generatedDouble();
        this.shortDescription = generateShortString();
        this.longText = generateLongString();
    }

    public SampleResponse(String shortDescription, String longText) {
        this.id = generateRandomInteger();
        this.timestamp = getTimestamp();
        this.uniqueId = generateUUID();
        this.randomDouble = generatedDouble();
        this.shortDescription = shortDescription;
        this.longText = longText;
    }

    private int generateRandomInteger() {
        return ThreadLocalRandom.current().nextInt(1, 99999 + 1);
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    private String getTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    private double generatedDouble() {
        double generatedDouble = new RandomDataGenerator().getRandomGenerator().nextDouble();
        return generatedDouble;
    }

    private String generateShortString() {
        return "Rebuilt and Around Since One Iguanodon Upon Jeepers Impatiently Immaculate Abnormal This Less " +
                "Constitutional Wow Less Stealthy";
    }

    private String generateLongString() {
        return "Like notwithstanding returned much turned darn yikes beside jeepers instead the overpaid reminantly " +
                "scowled far echidna a adequately that one one goodness apart some circa opposite away minute across " +
                "while hey much fruitlessly a groaned one a panda wow far bald famous hyena this one fluent spry goodness " +
                "the firefly until well darn one past one pending and yet the expansively a petted up less a from exited " +
                "cobra scowled fuzzy then however some fatal arose editorially promiscuous jubilantly impalpable llama " +
                "some more and preparatory goodness octopus well darn caribou some evasively preparatory much jeepers " +
                "meagerly save since up oh." +
                "Was until some much far among withdrew regardless pugnacious aptly that crud moronically darn therefore " +
                "krill because sincerely jeez jeez read preparatory this so dear hen lion impetuous however some after " +
                "goodness buoyant more some darn energetic because recklessly forward and so concretely met frog slavishly " +
                "one far yikes besides oh therefore this much sent hey jaded around less far and less darn as kept up " +
                "allegedly incongruously far cavalier that demonstrable hey so eel fluent brave therefore cow far rigid " +
                "proved well drove and and more but smirked a much some independently sparingly tearful into blind yikes " +
                "kookaburra so." +
                "Like notwithstanding returned much turned darn yikes beside jeepers instead the overpaid reminantly " +
                "scowled far echidna a adequately that one one goodness apart some circa opposite away minute across " +
                "while hey much fruitlessly a groaned one a panda wow far bald famous hyena this one fluent spry goodness " +
                "the firefly until well darn one past one pending and yet the expansively a petted up less a from exited " +
                "cobra scowled fuzzy then however some fatal arose editorially promiscuous jubilantly impalpable llama " +
                "some more and preparatory goodness octopus well darn caribou some evasively preparatory much jeepers " +
                "meagerly save since up oh." +
                "Was until some much far among withdrew regardless pugnacious aptly that crud moronically darn therefore " +
                "krill because sincerely jeez jeez read preparatory this so dear hen lion impetuous however some after " +
                "goodness buoyant more some darn energetic because recklessly forward and so concretely met frog slavishly " +
                "one far yikes besides oh therefore this much sent hey jaded around less far and less darn as kept up " +
                "allegedly incongruously far cavalier that demonstrable hey so eel fluent brave therefore cow far rigid " +
                "proved well drove and and more but smirked a much some independently sparingly tearful into blind yikes " +
                "kookaburra so." +
                "Piranha acceptable much and and rebuilt asininely neutral consolingly vulture gazelle so opposite out " +
                "hummingbird had dear and however by a otter forward squid chuckled therefore awkwardly overslept far " +
                "weasel some much regardless much overran fought grasshopper more far jeez chuckled crud magic petulantly " +
                "according impala nonchalant that moth kneeled placid absolute that quail random the far that mongoose " +
                "dragonfly well much told yikes ahead gosh dashing sudden hence far yikes authentically unselfishly fell " +
                "far that mighty positively overlaid amphibiously cardinal slept enticingly lucrative minute a leopard " +
                "strung a shined and banally and hence hello depending truthfully far aardvark filled.";
    }
}
