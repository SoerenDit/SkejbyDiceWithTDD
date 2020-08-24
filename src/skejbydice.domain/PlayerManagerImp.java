package skejbydice.domain;

import java.util.ArrayList;

public class PlayerManagerImp implements PlayerManager {
    ArrayList<Player> players;
    ChosePlayerStrategy chosePlayerStrategy;
    int currentPlayerIdx;
    Player playerUnderAttack;

    public PlayerManagerImp(ChosePlayerStrategy chosePlayerStrategy) {
        this.chosePlayerStrategy = chosePlayerStrategy;
        players = new ArrayList<>();
        currentPlayerIdx = 0;
    }

    @Override
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIdx);
    }


    @Override
    public Player chosePlayer() {
        return chosePlayerStrategy.chosePlayer();
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
    public void addPlayer(Player player) {
        players.add(player);
    }
}
