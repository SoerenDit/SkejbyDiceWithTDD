package skejbydice.standard.factories;

import skejbydice.framework.PlayerFactoryI;
import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.framework.strategies.DefenceStrategy;
import skejbydice.framework.strategies.RerollOrAttackStrategyI;
import skejbydice.standard.strategies.ChosePlayerToTheLeftStrategy;
import skejbydice.standard.strategies.NeverDefendYourselfStrategy;
import skejbydice.standard.strategies.NeverRerollStrategy;

public class BetaPlayerFactory implements PlayerFactoryI {
    
    @Override
    public ChosePlayerStrategyI createChosePlayerStrategy() {
        return new ChosePlayerToTheLeftStrategy();
    }

    @Override
    public DefenceStrategy createDefenceStrategy() {
        return new NeverDefendYourselfStrategy();
    }

    @Override
    public RerollOrAttackStrategyI createRerollOrAttackStrategy() {
        return new NeverRerollStrategy;
    }
}
