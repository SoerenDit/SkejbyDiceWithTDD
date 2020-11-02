package skejbydice.framework;

import skejbydice.framework.strategies.*;

public interface PlayerFactoryI {

    ChosePlayerStrategyI createChosePlayerStrategy();

    DecideNumberOfTurnsStrategy createDesignNumberOfTurnsStrategy();

    DefenceStrategy createDefenceStrategy();

    DieRollStrategyI createDieRollStrategy();

    RerollOrAttackStrategyI createRerollOrAttackStrategy();
}
