package skejbydice.domain;

public class LuckyDie implements Die {
    int faceUpNumber;
    DieRollStrategy dieRollStrategy;

    public LuckyDie(DieRollStrategy dieRollStrategy) {
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
}
