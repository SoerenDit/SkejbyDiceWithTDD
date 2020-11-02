package skejbydice.standard.factories;

import skejbydice.framework.PlayerFactoryI;
import skejbydice.framework.strategies.*;
import skejbydice.standard.strategies.AlwaysDefendYourselfStrategy;
import skejbydice.standard.strategies.ChosePlayerToTheLeftStrategy;
import skejbydice.standard.strategies.RerollOnceStrategy;


/*
    This player always choses the player to the left of himself, when he has to chose for any reasons.
    Whenever he is attacked he will always try to defend himself.
    He always rerolls the attacking dice once before attacking.
 */
public class AlphaPlayerFactory implements PlayerFactoryI {
    @Override
    public ChosePlayerStrategyI createChosePlayerStrategy() {
        return new ChosePlayerToTheLeftStrategy();
    }

    @Override
    public DefenceStrategy createDefenceStrategy() {
        return new AlwaysDefendYourselfStrategy();
    }

    @Override
    public RerollOrAttackStrategyI createRerollOrAttackStrategy() {
        return new RerollOnceStrategy();
    }
}
