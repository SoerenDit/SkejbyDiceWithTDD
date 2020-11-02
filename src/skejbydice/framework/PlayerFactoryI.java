package skejbydice.framework;

import skejbydice.framework.strategies.*;

public interface PlayerFactoryI {

    ChosePlayerStrategyI createChosePlayerStrategy();

    DefenceStrategy createDefenceStrategy();

    RerollOrAttackStrategyI createRerollOrAttackStrategy();
}
