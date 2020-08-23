package skejbydice.domain;

public class LuckyDie extends Die {

    public LuckyDie(DieRollStrategy dieRollStrategy) {
        super(dieRollStrategy);
    }

    public void increaseByOne() {
        if(number < 6) number++;
    }

    public void decreaseByOne() {
        if(number > 1) number--;
    }
}
