package skejbydice.domain;

public class DecisionManager implements DecisionManagerI {
    ChosePlayerStrategyI chosePlayerStrategy;
    RerollOrAttackStrategyI rerollOrAttackStrategy;
    DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy;
    private DefenceStrategy defenceStrategy;

    public DecisionManager(ChosePlayerStrategyI chosePlayerStrategy, RerollOrAttackStrategyI rerollOrAttackStrategy, DefenceStrategy defenceStrategy, DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy) {
        this.chosePlayerStrategy = chosePlayerStrategy;
        this.rerollOrAttackStrategy = rerollOrAttackStrategy;
        this.decideNumberOfTurnsStrategy = decideNumberOfTurnsStrategy;
    }

    @Override
    public Player chosePlayer() {
        return chosePlayerStrategy.chosePlayer();
    }

    @Override
    public boolean willYouDrinkAndReroll() {
        return rerollOrAttackStrategy.willYouDrinkAndReroll();
    }

    @Override
    public boolean isThisTheLastTurn() {
        return decideNumberOfTurnsStrategy.wasThisTheLastTurn();
    }

    @Override
    public void setRerollOrAttackStrategy(RerollOrAttackStrategyI rerollOrAttackStrategy) {
        this.rerollOrAttackStrategy = rerollOrAttackStrategy;
    }

    @Override
    public void setDefenceStrategy(DefenceStrategy defenceStrategy) {
        this.defenceStrategy = defenceStrategy;
    }
}
