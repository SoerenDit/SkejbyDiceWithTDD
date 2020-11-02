package skejbydice.standard.strategies;

import skejbydice.framework.strategies.DefenceStrategy;

public class AlwaysDefendYourselfStrategy implements DefenceStrategy {

    @Override
    public boolean willHeDefendHimself() {
        return true;
    }
}