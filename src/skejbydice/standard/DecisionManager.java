package skejbydice.standard;

import skejbydice.framework.*;
import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.framework.strategies.DecideNumberOfTurnsStrategy;
import skejbydice.framework.strategies.DefenceStrategy;
import skejbydice.framework.strategies.RerollOrAttackStrategyI;

public class DecisionManager implements DecisionManagerI {
    private ChosePlayerStrategyI chosePlayerStrategy;
    private DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy;

    public DecisionManager(DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy) {
        this.decideNumberOfTurnsStrategy = decideNumberOfTurnsStrategy;
    }

    @Override
    public boolean isThisTheLastTurn() {
        return decideNumberOfTurnsStrategy.wasThisTheLastTurn();
    }

}
