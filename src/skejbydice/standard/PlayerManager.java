package skejbydice.standard;

import java.util.ArrayList;

public class PlayerManager {
    ArrayList<Player> players;
    private int currentPlayerIdx;
    private Player playerUnderAttack;

    public PlayerManager() {
        players = new ArrayList<>();
        currentPlayerIdx = 0;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }

    public Player getPlayerUnderAttack() {
        return playerUnderAttack;
    }

    public void setPlayerUnderAttack(Player player) {
        playerUnderAttack = player;
    }

    public void nextPlayer() {
        if(currentPlayerIdx < players.size()-1) currentPlayerIdx++;
        else currentPlayerIdx = 0;
    }

    public void increaseActivePlayerSips(int numberOfSipsToGiveAway) {
        getCurrentPlayer().drinkSips(numberOfSipsToGiveAway);
    }

    public void makePlayerDrink(Player player, int sips) {
        player.drinkSips(sips);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
