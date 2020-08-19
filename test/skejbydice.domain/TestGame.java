package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

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
        assertThat(g.getPlayer(0), is(p));
    }

    @Test
    public void shouldAddTwoPlayersToGame() {
        List<Player> players = new ArrayList<Player>();
        Player alpha = new Player("Alpha");
        Player beta = new Player("Beta");
        g.addPlayer(alpha);
        g.addPlayer(beta);
        assertThat(g.getPlayer(0), is(alpha));
        assertThat(g.getPlayer(1), is(beta));
    }

}
