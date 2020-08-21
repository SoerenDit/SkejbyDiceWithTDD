package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestDiceManager {
    DiceManager diceManager;

    @Before
    public void setUp() {
        diceManager = new DiceManager();
    }

    @Test
    public void shouldReturnTheSumOfTheAttackingDice() throws InvalidDieNumberException {
        diceManager.setAttackingDice(6,6);
        assertThat(diceManager.getSumOfAttackingDice(),is(12));
    }
}
