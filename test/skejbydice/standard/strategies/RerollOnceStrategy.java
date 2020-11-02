package skejbydice.standard.strategies;

import skejbydice.framework.strategies.RerollOrAttackStrategyI;

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
