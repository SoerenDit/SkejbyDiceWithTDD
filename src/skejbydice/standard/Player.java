package skejbydice.standard;

import skejbydice.framework.PlayerFactoryI;
import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.framework.strategies.DefenceStrategy;
import skejbydice.framework.strategies.RerollOrAttackStrategyI;
import skejbydice.standard.strategies.RandomRollStrategy;

public class Player {
    private int sips;
    private int beers;
    private String name;
    private LuckyDie luckyDie;
    private RerollOrAttackStrategyI rerollOrAttackStrategy;
    private DefenceStrategy defenceStrategy;
    private ChosePlayerStrategyI chosePlayerStrategy;

    public Player(String name, PlayerFactoryI playerFactory) {
        this.name = name;
        sips = 0;
        beers = 0;
        luckyDie = new LuckyDie(new RandomRollStrategy());
        rerollOrAttackStrategy = playerFactory.createRerollOrAttackStrategy();
        defenceStrategy = playerFactory.createDefenceStrategy();
        chosePlayerStrategy = playerFactory.createChosePlayerStrategy();
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

    public boolean willYouDrinkAndReroll() {
        return rerollOrAttackStrategy.willYouDrinkAndReroll();
    }

    public boolean willYouDefendYourself() {
        return defenceStrategy.willYouDefendYourself();
    }

    public int chosePlayer() {
        return chosePlayerStrategy.chosePlayer();
    }
}
