package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestDiceManager {
    DiceManagerImpForTest diceManagerImpForTest;

    @Before
    public void setUp() {
        diceManagerImpForTest = new DiceManagerImpForTest();
    }

    @Test
    public void shouldReturnTheSumOfTheAttackingDice() throws InvalidDieNumberException {
        diceManagerImpForTest.setAttackingDice(6,6);
        assertThat(diceManagerImpForTest.getSumOfAttackingDice(),is(12));
    }
}
