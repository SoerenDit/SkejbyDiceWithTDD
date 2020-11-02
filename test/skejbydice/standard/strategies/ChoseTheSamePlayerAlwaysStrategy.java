package skejbydice.standard.strategies;

import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.standard.Player;

public class ChoseTheSamePlayerAlwaysStrategy implements ChosePlayerStrategyI {
    Player player;

    public ChoseTheSamePlayerAlwaysStrategy(Player player) {
        this.player = player;
    }
    @Override
    public Player chosePlayer() {
        return player;
    }
}
