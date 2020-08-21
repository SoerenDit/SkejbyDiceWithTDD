package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestAttack {
    DiceManagerImp diceManagerImp;

    @Before
    public void setUp() {
        diceManagerImp = new DiceManagerImp();
    }

    @Test
    public void shouldReturnTheSumOfTheAttackingDice() throws InvalidDieNumberException {
        diceManagerImp.setAttackingDice(6,6);
        assertThat(diceManagerImp.getSumOfAttackingDice(),is(12));
    }

    @Test
    public void shouldReturnThatRollingA3AndA5Gives4Sips() throws InvalidDieNumberException {
        diceManagerImp.setAttackingDice(3,5);
        assertThat(diceManagerImp.getNumberOfSipsToGiveAway(),is(4));
    }

    @Test
    public void shouldReturnThatRollingA3AndA6Gives4Sips() throws InvalidDieNumberException {
        diceManagerImp.setAttackingDice(3,6);
        assertThat(diceManagerImp.getNumberOfSipsToGiveAway(),is(4));
    }

}
