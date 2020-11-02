package skejbydice.framework;

import skejbydice.framework.strategies.DefenceStrategy;
import skejbydice.framework.strategies.RerollOrAttackStrategyI;
import skejbydice.standard.Player;

public interface DecisionManagerI {
    Player chosePlayer();
    boolean willYouDrinkAndReroll();
    boolean isThisTheLastTurn();
    boolean willAttackedPlayerDefendHimself();

    void setRerollOrAttackStrategy(RerollOrAttackStrategyI rerollOrAttackStrategy);

    void setDefenceStrategy(DefenceStrategy defenceStrategy);


}
