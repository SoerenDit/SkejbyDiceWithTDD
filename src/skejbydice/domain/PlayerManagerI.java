package skejbydice.domain;

public interface PlayerManagerI {
    void addPlayer(Player player);
    Player getCurrentPlayer();
    Player getPlayerUnderAttack();
    void setPlayerUnderAttack(Player player);
    void nextPlayer();

    void increaseActivePlayerSips(int numberOfSipsToGiveAway);
}
