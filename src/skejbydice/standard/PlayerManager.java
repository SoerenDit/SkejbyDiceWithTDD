package skejbydice.standard;

import skejbydice.framework.PlayerManagerI;
import skejbydice.standard.Player;

import java.util.ArrayList;

public class PlayerManager implements PlayerManagerI {
    ArrayList<Player> players;
    private int currentPlayerIdx;
    private Player playerUnderAttack;
    private Player losingPlayer;

    public PlayerManager() {
        players = new ArrayList<>();
        currentPlayerIdx = 0;
    }

    @Override
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }

    @Override
    public Player getPlayerUnderAttack() {
        return playerUnderAttack;
    }

    @Override
    public void setPlayerUnderAttack(Player player) {
        playerUnderAttack = player;
    }

    @Override
    public void nextPlayer() {
        if(currentPlayerIdx < players.size()-1) currentPlayerIdx++;
        else currentPlayerIdx = 0;
    }

    @Override
    public void increaseActivePlayerSips(int numberOfSipsToGiveAway) {
        getCurrentPlayer().drinkSips(numberOfSipsToGiveAway);
    }

    public void punishLosingPlayer(int numberOfSips) {
        losingPlayer.drinkSips(numberOfSips);
    }

    @Override
    public void setLosingPlayer(Player losingPlayer) {
        this.losingPlayer = losingPlayer;
    }

    public Player getLosingPlayer() {
        return losingPlayer;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getCurrentPlayerIdx() {
        return currentPlayerIdx;
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }
}
