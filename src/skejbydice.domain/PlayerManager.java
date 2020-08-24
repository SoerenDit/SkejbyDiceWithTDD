package skejbydice.domain;

public interface PlayerManager {
    void addPlayer(Player player);
    Player getCurrentPlayer();
    Player chosePlayer();
    Player getPlayerUnderAttack();
    void setPlayerUnderAttack(Player player);
    void nextPlayer();


}
