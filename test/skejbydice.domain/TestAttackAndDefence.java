package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestAttackAndDefence {

    @Test
    public void shouldReturnThatRollingA3AndA5Gives4Sips() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(5),die(6));
        diceManager.rollAttackingDice();
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(4));
    }

    @Test
    public void shouldReturnThatRollingA3AndA6Gives4Sips() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(6),die(6));
        diceManager.rollAttackingDice();
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(4));
    }

    @Test
    public void secondAttackingRollShouldRoundUpWhenDecidingNumberOfSips() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(6),die(6));
        diceManager.rollAttackingDice();
        diceManager.setFirstAttackingRoll(false);
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(5));
    }

    @Test
    public void rollingA6ShouldDefendYouFrom3And6Attack() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(6),die(6));
        diceManager.rollAttackingDice();
        diceManager.rollDefendingDice();
        assertTrue(diceManager.isDefenceSuccesful());
    }

    @Test
    public void rollingA5ShouldNotDefendYouFrom3And6Attack() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(6),die(5));
        diceManager.rollAttackingDice();
        diceManager.rollDefendingDice();
        assertFalse(diceManager.isDefenceSuccesful());
    }

    // Helper method to create a die with a fixed number
    private Die die(int i) throws InvalidDieNumberException {
        return new Die(new FixedNumberRollStrategy(i));
    }
}
