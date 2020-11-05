package skejbydice.standard;

import skejbydice.framework.DieI;
import skejbydice.framework.strategies.DieRollStrategyI;

public class RegularDie implements DieI {
    private int faceUpNumber;
    private DieRollStrategyI dieRollStrategy;

    public RegularDie(DieRollStrategyI dieRollStrategy) {
        faceUpNumber = 0;
        this.dieRollStrategy = dieRollStrategy;
    }

    public int getFaceUpNumber() {
        return faceUpNumber;
    }

    public void roll() {
        faceUpNumber = dieRollStrategy.roll();
    }

    public void changeRollStrategy(DieRollStrategyI dieRollStrategy) {
        this.dieRollStrategy = dieRollStrategy;
    }
}
