package skejbydice.standard.factories;

import skejbydice.framework.PlayerFactoryI;
import skejbydice.framework.strategies.*;
import skejbydice.standard.strategies.AlwaysDefendYourselfStrategy;
import skejbydice.standard.strategies.ChosePlayerToTheLeftStrategy;
import skejbydice.standard.strategies.RerollOnceStrategy;

public class AlphaPlayerFactoy implements PlayerFactoryI {
    @Override
    public ChosePlayerStrategyI createChosePlayerStrategy() {
        return new ChosePlayerToTheLeftStrategy();
    }

    @Override
    public DecideNumberOfTurnsStrategy createDesignNumberOfTurnsStrategy() {
        return null;
    }

    @Override
    public DefenceStrategy createDefenceStrategy() {
        return new AlwaysDefendYourselfStrategy();
    }

    @Override
    public DieRollStrategyI createDieRollStrategy() {
        return null;
    }

    @Override
    public RerollOrAttackStrategyI createRerollOrAttackStrategy() {
        return new RerollOnceStrategy();
    }
}
