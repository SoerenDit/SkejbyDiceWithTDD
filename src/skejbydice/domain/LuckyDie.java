package skejbydice.domain;

public class LuckyDie implements DieI {
    int faceUpNumber;
    DieRollStrategyI dieRollStrategy;

    public LuckyDie(DieRollStrategyI dieRollStrategy) {
        this.dieRollStrategy = dieRollStrategy;
        faceUpNumber = 1;
    }

    public void increaseByOne() {
        if(faceUpNumber < 6) faceUpNumber++;
    }

    public void decreaseByOne() {
        if(faceUpNumber > 1) faceUpNumber--;
    }

    @Override
    public void roll() {
        dieRollStrategy.roll();
    }

    @Override
    public int getFaceUpNumber() {
        return faceUpNumber;
    }

    @Override
    public void changeRollStrategy(DieRollStrategyI dieRollStrategy) {
        this.dieRollStrategy = dieRollStrategy;
    }
}
