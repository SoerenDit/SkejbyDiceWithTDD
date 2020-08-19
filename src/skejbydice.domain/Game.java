package skejbydice.domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;

    public Game() {
        players = new ArrayList<Player>();
    }


    public void addPlayer(Player p) {
        players.add(p);
    }


    public Player getPlayer(int i) {
        return players.get(i);
    }
}
