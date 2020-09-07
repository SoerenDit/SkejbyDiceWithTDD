package skejbydice.domain;

public interface DecisionManagerI {
    Player chosePlayer();
    boolean willYouDrinkAndReroll();
    boolean isThisTheLastTurn();
    boolean willAttackedPlayerDefendHimself();

    void setRerollOrAttackStrategy(RerollOrAttackStrategyI rerollOrAttackStrategy);

    void setDefenceStrategy(DefenceStrategy defenceStrategy);


}
