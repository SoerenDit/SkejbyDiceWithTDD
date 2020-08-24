package skejbydice.domain;

public interface DecisionManagerI {
    Player chosePlayer();
    boolean willYouDrinkAndReroll();
    boolean isThisTheLastTurn();
}
