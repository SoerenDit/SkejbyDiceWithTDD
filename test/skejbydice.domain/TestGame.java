package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestGame {
    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }

    @Test
    public void shouldAddPlayerAlphaToGame() {
        Player p = new Player("Alpha");
        g.addPlayer(p);
        assertThat(g.getPlayer(), is(p));
    }

}
