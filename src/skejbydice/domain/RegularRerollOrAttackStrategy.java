package skejbydice.domain;

public class RegularRerollOrAttackStrategy implements RerollOrAttackStrategyI {
    @Override
    public boolean willYouDrinkAndReroll() {
        return false;
    }
}
