package skejbydice.domain;

public class RegularDecideNumberOfTurnsStrategy implements DecideNumberOfTurnsStrategy {
    @Override
    public boolean wasThisTheLastTurn() {
        return false;
    }
}
