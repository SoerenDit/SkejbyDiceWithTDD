package skejbydice.domain;

import skejbydice.domain.RerollOrAttackStrategyI;

public class RerollOnceStrategy implements RerollOrAttackStrategyI {
    private int rerollNumber;
    private int maxRerollNunber;

    public RerollOnceStrategy() {
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
