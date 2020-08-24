package skejbydice.domain;

public class DecisionManager implements DecisionManagerI {
    ChosePlayerStrategyI chosePlayerStrategy;

    public DecisionManager(ChosePlayerStrategyI chosePlayerStrategy) {
        this.chosePlayerStrategy = chosePlayerStrategy;
    }

    @Override
    public Player chosePlayer() {
        return chosePlayerStrategy.chosePlayer();
    }

    @Override
    public boolean doYouWantToDrinkTheSipsYourself() {
        return true;
    }
}
