package skejbydice.standard.strategies;

import skejbydice.framework.strategies.DieRollStrategyI;
import skejbydice.standard.InvalidDieNumberException;

public class FixedNumberRollStrategy implements DieRollStrategyI {
    private int number;

    public FixedNumberRollStrategy(int number) throws InvalidDieNumberException {
        if(number < 1 || number > 6) throw new InvalidDieNumberException("Invalid die number: " + number);
        this.number = number;
    }

    @Override
    public int roll() {
        return number;
    }
}
