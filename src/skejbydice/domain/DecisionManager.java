package skejbydice.domain;

public class DecisionManager implements DecisionManagerI {
    private ChosePlayerStrategyI chosePlayerStrategy;
    private RerollOrAttackStrategyI rerollOrAttackStrategy;
    private DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy;
    private DefenceStrategy defenceStrategy;

    public DecisionManager(ChosePlayerStrategyI chosePlayerStrategy, RerollOrAttackStrategyI rerollOrAttackStrategy, DefenceStrategy defenceStrategy, DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy) {
        this.chosePlayerStrategy = chosePlayerStrategy;
        this.rerollOrAttackStrategy = rerollOrAttackStrategy;
        this.defenceStrategy = defenceStrategy;
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
    public boolean willAttackedPlayerDefendHimself() { return defenceStrategy.willHeDefendHimself(); }

    @Override
    public void setRerollOrAttackStrategy(RerollOrAttackStrategyI rerollOrAttackStrategy) {
        this.rerollOrAttackStrategy = rerollOrAttackStrategy;
    }

    @Override
    public void setDefenceStrategy(DefenceStrategy defenceStrategy) {
        this.defenceStrategy = defenceStrategy;
    }
}
