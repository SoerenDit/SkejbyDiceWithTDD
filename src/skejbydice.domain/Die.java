package skejbydice.domain;

import java.util.Random;

public class Die {
    protected int number;
    private DieRollStrategy dieRollStrategy;

    public Die(DieRollStrategy dieRollStrategy) {
        number = 1;
        this.dieRollStrategy = dieRollStrategy;
    }


    public int getNumber() {
        return number;
    }

    public void roll() {
        number = dieRollStrategy.roll();
    }



}
