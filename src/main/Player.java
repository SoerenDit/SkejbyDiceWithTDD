package main;

public class Player {
    private int sips;

    public Player() {
        sips = 0;
    }
    public void drinkSips(int i) {
        sips += i;
    }

    public Integer getSips() {
        return sips;
    }
}
