package skejbydice.standard.strategies;

import skejbydice.framework.strategies.DecideNumberOfTurnsStrategy;

public class RegularDecideNumberOfTurnsStrategy implements DecideNumberOfTurnsStrategy {
    @Override
    public boolean wasThisTheLastTurn() {
        return false;
    }
}
