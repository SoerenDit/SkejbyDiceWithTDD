package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestChosePlayerStrategy {
    private ChosePlayerStrategy chosePlayerStrategy;
    private Player beta;

    @Before
    public void setUp() {
        beta = new Player("Beta");
        chosePlayerStrategy = new ChoseTheSamePlayerAlwaysStrategy(beta);
    }

    @Test
    public void shouldReturnPlayerBeta() {
        assertThat(chosePlayerStrategy.chosePlayer(), is(beta));
    }
}
