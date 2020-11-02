package skejbydice.framework;

import skejbydice.framework.strategies.DefenceStrategy;
import skejbydice.framework.strategies.RerollOrAttackStrategyI;
import skejbydice.standard.Player;

public interface DecisionManagerI {
    boolean isThisTheLastTurn();
}
