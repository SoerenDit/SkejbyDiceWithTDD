package skejbydice.domain;

import java.util.Random;

public class FakeDie extends Die {

    public void setNumber(int n) throws InvalidDieNumberException  {
        if(n < 1 || n > 6) throw new InvalidDieNumberException("Invalid die number: " + n);
        number = n;
    }
}
