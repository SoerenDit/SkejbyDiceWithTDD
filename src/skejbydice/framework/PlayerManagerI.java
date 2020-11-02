package skejbydice.framework;

import skejbydice.standard.Player;

public interface PlayerManagerI {
    void addPlayer(Player player);
    Player getCurrentPlayer();
    Player getPlayerUnderAttack();
    void setPlayerUnderAttack(Player player);
    void nextPlayer();

    void increaseActivePlayerSips(int numberOfSipsToGiveAway);

    void setLosingPlayer(Player losingPlayer);
}
