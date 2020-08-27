package skejbydice.domain;

import java.util.Random;

public class RandomRollStrategy implements DieRollStrategyI {

    @Override
    public int roll() {
        Random rand = new Random();
        return rand.nextInt(6)+1;
    }
}
