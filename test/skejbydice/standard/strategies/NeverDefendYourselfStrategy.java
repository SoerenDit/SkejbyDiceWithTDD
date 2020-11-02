package skejbydice.standard.strategies;

import skejbydice.framework.strategies.DefenceStrategy;

public class NeverDefendYourselfStrategy implements DefenceStrategy {
    @Override
    public boolean willYouDefendYourself() {
        return false;
    }
}
