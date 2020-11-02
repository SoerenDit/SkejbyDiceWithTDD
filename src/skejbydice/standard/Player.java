package skejbydice.standard;

import skejbydice.framework.PlayerFactoryI;
import skejbydice.standard.LuckyDie;
import skejbydice.standard.strategies.RandomRollStrategy;

public class Player {
    private int sips;
    private int beers;
    private String name;
    private LuckyDie luckyDie;

    public Player(String name, PlayerFactoryI playerFactoryI) {
        this.name = name;
        sips = 0;
        beers = 0;
        luckyDie = new LuckyDie(new RandomRollStrategy());
    }

    public void drinkSips(int i) {
        if (sips + i >= 14) {
            emptyBeer();
        } else {
            sips += i;
        }
    }

    public Integer getSips() {
        return sips;
    }

    public void emptyBeer() {
        beers += 1;
        sips = 0;
    }

    public Integer getNumberOfBeers() {
        return beers;
    }

    public String getName() {
        return name;
    }

    public String getLuckyDieNumber() {
        return "" + luckyDie.getFaceUpNumber();
    }
}
