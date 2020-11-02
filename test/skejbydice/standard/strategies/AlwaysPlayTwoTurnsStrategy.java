package skejbydice.standard.strategies;

import skejbydice.framework.strategies.DecideNumberOfTurnsStrategy;

public class AlwaysPlayTwoTurnsStrategy implements DecideNumberOfTurnsStrategy {
    int turnNumber;

    public AlwaysPlayTwoTurnsStrategy() {
        turnNumber = 1;
    }
    @Override
    public boolean wasThisTheLastTurn() {
        if(turnNumber < 2) {
            turnNumber++;
            return false;
        }
        else {
            return true;
        }
    }
}
