package skejbydice.domain;

import java.util.Random;

public class Die {
    protected int number;

    public Die() {
        number = 1;
    }

    public int getNumber() {
        return number;
    }

    public void roll() {
        Random rand = new Random();
        number = rand.nextInt(6)+1;
    }

}
