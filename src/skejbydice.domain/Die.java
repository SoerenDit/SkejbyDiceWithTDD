package skejbydice.domain;

public class Die {
    protected int faceUpNumber;
    private DieRollStrategy dieRollStrategy;

    public Die(DieRollStrategy dieRollStrategy) {
        faceUpNumber = 1;
        this.dieRollStrategy = dieRollStrategy;
    }

    public int getFaceUpNumber() {
        return faceUpNumber;
    }

    public void roll() {
        faceUpNumber = dieRollStrategy.roll();
    }
}
