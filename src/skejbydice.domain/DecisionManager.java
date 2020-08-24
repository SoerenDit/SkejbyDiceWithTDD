package skejbydice.domain;

public class DecisionManager implements DecisionManagerI {
    ChosePlayerStrategyI chosePlayerStrategy;
    RerollOrAttackStrategyI rerollOrAttackStrategy;

    public DecisionManager(ChosePlayerStrategyI chosePlayerStrategy, RerollOrAttackStrategyI rerollOrAttackStrategy) {
        this.chosePlayerStrategy = chosePlayerStrategy;
        this.rerollOrAttackStrategy = rerollOrAttackStrategy;
    }

    @Override
    public Player chosePlayer() {
        return chosePlayerStrategy.chosePlayer();
    }

    @Override
    public boolean willYouDrinkAndReroll() {
        return rerollOrAttackStrategy.willYouDrinkAndReroll();
    }
}
