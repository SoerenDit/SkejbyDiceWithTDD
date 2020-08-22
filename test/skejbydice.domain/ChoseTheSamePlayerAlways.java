package skejbydice.domain;

public class ChoseTheSamePlayerAlways implements ChosePlayerStrategy{
    Player player;

    public ChoseTheSamePlayerAlways(Player player) {
        this.player = player;
    }
    @Override
    public Player chosePlayer() {
        return player;
    }
}
