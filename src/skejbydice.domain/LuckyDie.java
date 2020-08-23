package skejbydice.domain;

public class LuckyDie extends Die {

    public LuckyDie(DieRollStrategy dieRollStrategy) {
        super(dieRollStrategy);
    }

    public void increaseByOne() {
        if(faceUpNumber < 6) faceUpNumber++;
    }

    public void decreaseByOne() {
        if(faceUpNumber > 1) faceUpNumber--;
    }
}
