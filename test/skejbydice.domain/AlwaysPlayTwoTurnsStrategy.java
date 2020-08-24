package skejbydice.domain;

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
