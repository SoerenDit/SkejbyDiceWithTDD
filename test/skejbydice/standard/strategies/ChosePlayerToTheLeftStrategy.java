package skejbydice.standard.strategies;

import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.standard.Game;
import skejbydice.standard.Player;

public class ChosePlayerToTheLeftStrategy implements ChosePlayerStrategyI {

    @Override
    public int chosePlayer() {
        return 1;
    }
}
