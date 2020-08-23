package skejbydice.domain;

import java.util.Random;

public class RandomRollStrategy implements DieRollStrategy {

    @Override
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }
}
