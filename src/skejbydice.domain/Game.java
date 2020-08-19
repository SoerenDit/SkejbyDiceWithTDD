package skejbydice.domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int currentPlayer;

    public Game() {
        players = new ArrayList<Player>();
        currentPlayer = 0;
    }


    public void addPlayer(Player p) {
        players.add(p);
    }


    public Player getPlayer(int i) {
        return players.get(i);
    }

    public Player whoseTurnIsIt() {
        return players.get(currentPlayer);
    }

    public void nextPlayer() {
        if(currentPlayer + 1 < players.size()) currentPlayer++;
        else currentPlayer = 0;
    }
}
