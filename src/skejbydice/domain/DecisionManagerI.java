package skejbydice.domain;

public interface DecisionManagerI {
    Player chosePlayer();
    boolean willYouDrinkAndReroll();
    boolean isThisTheLastTurn();

    void setRerollOrAttackStrategy(RerollOrAttackStrategyI rerollOrAttackStrategy);

    void setDefenceStrategy(DefenceStrategy defenceStrategy);
}
