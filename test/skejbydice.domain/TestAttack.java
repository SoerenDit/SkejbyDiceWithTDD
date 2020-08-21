package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestAttack {
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

    @Test
    public void shouldReturnThatRollingA3AndA5Gives4Sips() throws InvalidDieNumberException {
        diceManagerImpForTest.setAttackingDice(3,5);
        assertThat(diceManagerImpForTest.getNumberOfSipsToGiveAway(),is(4));
    }

    @Test
    public void shouldReturnThatRollingA3AndA6Gives4Sips() throws InvalidDieNumberException {
        diceManagerImpForTest.setAttackingDice(3,6);
        assertThat(diceManagerImpForTest.getNumberOfSipsToGiveAway(),is(4));
    }

}
