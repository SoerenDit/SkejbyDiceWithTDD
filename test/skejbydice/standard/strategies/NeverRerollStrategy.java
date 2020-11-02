package skejbydice.standard.strategies;

import skejbydice.framework.strategies.RerollOrAttackStrategyI;

public class NeverRerollStrategy implements RerollOrAttackStrategyI {
    @Override
    public boolean willYouDrinkAndReroll() {
        return false;
    }
}
