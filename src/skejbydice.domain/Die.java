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

    public void setNumber(int n) throws InvalidDieNumberException  {
        if(n < 1 || n > 6) throw new InvalidDieNumberException("Invalid die number: " + n);
        number = n;
    }

}
