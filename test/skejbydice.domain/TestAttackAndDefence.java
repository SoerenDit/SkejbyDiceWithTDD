package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestAttackAndDefence {
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

    @Test
    public void shouldReturnThatRollingA3AndA5Gives4Sips() throws InvalidDieNumberException {
        diceManager.setAttackingDice(3,5);
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(4));
    }

    @Test
    public void shouldReturnThatRollingA3AndA6Gives4Sips() throws InvalidDieNumberException {
        diceManager.setAttackingDice(3,6);
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(4));
    }

    @Test
    public void secondAttackingRollShouldRoundUpWhenDecidingNumberOfSips() throws InvalidDieNumberException {
        diceManager.setFirstAttackingRoll(false);
        diceManager.setAttackingDice(3,6);
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(5));

    }

    @Test
    public void rollingA6ShouldDefendYouFrom3And6Attack() throws InvalidDieNumberException {
        diceManager.setAttackingDice(3,6);
        diceManager.setDefendingDie(6);
        assertTrue(diceManager.isDefenceSuccesful());
    }

    @Test
    public void rollingA5ShouldNotDefendYouFrom3And6Attack() throws InvalidDieNumberException {
        diceManager.setAttackingDice(3,6);
        diceManager.setDefendingDie(5);
        assertFalse(diceManager.isDefenceSuccesful());
    }

}
