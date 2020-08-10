package main;

import java.util.Random;

public class Die {
    int number;

    public Die() {
        number = 1;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int n) {
        number = n;
    }

    public void roll() {
        Random rand = new Random();
        number = rand.nextInt(6)+1;
    }
}
