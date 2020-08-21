package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestAttack {
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

}
