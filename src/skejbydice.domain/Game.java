package skejbydice.domain;

public class Game {
    private Player p;

    public Game() {
        p = new Player("Default");
    }

    public Player getPlayer() {
        return p;
    }


    public void addPlayer(Player p) {
        this.p = p;
    }
}
