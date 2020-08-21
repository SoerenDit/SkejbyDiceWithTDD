package skejbydice.domain;

import java.util.Random;

public class RegularDie implements Die {
    int number;

    public RegularDie() {
        number = 1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int n) throws InvalidDieNumberException  {
        if(n < 1 || n > 6) throw new InvalidDieNumberException("Invalid die number: " + n);
        number = n;
    }

    public void roll() {
        Random rand = new Random();
        number = rand.nextInt(6)+1;
    }
}
