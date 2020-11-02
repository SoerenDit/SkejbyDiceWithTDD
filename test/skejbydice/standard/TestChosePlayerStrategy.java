package skejbydice.standard;

import org.junit.Before;
import org.junit.Test;
import skejbydice.framework.factories.AlphaPlayerFactoy;
import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.standard.strategies.ChoseTheSamePlayerAlwaysStrategy;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestChosePlayerStrategy {
    private ChosePlayerStrategyI chosePlayerStrategy;
    private Player beta;

    @Before
    public void setUp() {
        beta = new Player("Beta", new AlphaPlayerFactoy());
        chosePlayerStrategy = new ChoseTheSamePlayerAlwaysStrategy(beta);
    }

    @Test
    public void shouldReturnPlayerBeta() {
        assertThat(chosePlayerStrategy.chosePlayer(), is(beta));
    }
}
