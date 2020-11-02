package skejbydice.framework;

import skejbydice.framework.strategies.DieRollStrategyI;

public interface DieI {
    void roll();
    int getFaceUpNumber();
    void changeRollStrategy(DieRollStrategyI dieRollStrategy);
}
