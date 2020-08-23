package skejbydice.domain;

public class ChoseTheSamePlayerAlwaysStrategy implements ChosePlayerStrategy{
    Player player;

    public ChoseTheSamePlayerAlwaysStrategy(Player player) {
        this.player = player;
    }
    @Override
    public Player chosePlayer() {
        return player;
    }
}
