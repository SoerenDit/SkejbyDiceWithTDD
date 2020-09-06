package skejbydice.domain;

public class NeverRerollStrategy implements RerollOrAttackStrategyI {
    @Override
    public boolean willYouDrinkAndReroll() {
        return false;
    }
}
