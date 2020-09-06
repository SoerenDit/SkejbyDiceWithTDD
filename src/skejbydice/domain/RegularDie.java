package skejbydice.domain;

public class RegularDie implements DieI {
    protected int faceUpNumber;
    private DieRollStrategyI dieRollStrategy;

    public RegularDie(DieRollStrategyI dieRollStrategy) {
        faceUpNumber = 1;
        this.dieRollStrategy = dieRollStrategy;
    }

    public int getFaceUpNumber() {
        return faceUpNumber;
    }

    public void roll() {
        faceUpNumber = dieRollStrategy.roll();
    }

    public void changeRollStrategy(skejbydice.domain.DieRollStrategyI dieRollStrategy) {
        this.dieRollStrategy = dieRollStrategy;
    }
}
