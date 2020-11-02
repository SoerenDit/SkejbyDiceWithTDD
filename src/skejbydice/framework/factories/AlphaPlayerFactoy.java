package skejbydice.framework.factories;

import skejbydice.framework.PlayerFactoryI;
import skejbydice.framework.strategies.*;

public class AlphaPlayerFactoy implements PlayerFactoryI {
    @Override
    public ChosePlayerStrategyI createChosePlayerStrategy() {
        return null;
    }

    @Override
    public DecideNumberOfTurnsStrategy createDesignNumberOfTurnsStrategy() {
        return null;
    }

    @Override
    public DefenceStrategy createDefenceStrategy() {
        return null;
    }

    @Override
    public DieRollStrategyI createDieRollStrategy() {
        return null;
    }

    @Override
    public RerollOrAttackStrategyI createRerollOrAttackStrategy() {
        return null;
    }
}
