package skejbydice.standard;

import org.junit.Test;
import skejbydice.standard.strategies.FixedNumberRollStrategy;

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
        diceManager.rollAttackingDice();
        assertThat(diceManager.getNumberOfSipsToGiveAway(),is(5));
    }

    @Test
    public void rollingA6ShouldDefendYouFrom3And6Attack() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(6),die(6));
        diceManager.rollAttackingDice();
        diceManager.rollDefenceDie();
        assertTrue(diceManager.isDefenceSuccesful());
    }

    @Test
    public void rollingA5ShouldNotDefendYouFrom3And6Attack() throws InvalidDieNumberException {
        DiceManager diceManager = new DiceManager(die(3),die(6),die(5));
        diceManager.rollAttackingDice();
        diceManager.rollDefenceDie();
        assertFalse(diceManager.isDefenceSuccesful());
    }

    // Helper method to create a die with a fixed number
    private RegularDie die(int i) throws InvalidDieNumberException {
        return new RegularDie(new FixedNumberRollStrategy(i));
    }


}
