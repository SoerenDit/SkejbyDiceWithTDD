package skejbydice.domain;

import skejbydice.domain.RerollOrAttackStrategyI;

public class AlwaysRerollOnceStrategy implements RerollOrAttackStrategyI {
    private int rerollNumber;
    private int maxRerollNunber;

    public AlwaysRerollOnceStrategy() {
        rerollNumber = 0;
        maxRerollNunber = 1;
    }
    @Override
    public boolean willYouDrinkAndReroll() {
        if(rerollNumber < maxRerollNunber) {
            rerollNumber++;
            return true;
        } else {
            return false;
        }
    }
}