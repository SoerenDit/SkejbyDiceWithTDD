package skejbydice.domain;

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
