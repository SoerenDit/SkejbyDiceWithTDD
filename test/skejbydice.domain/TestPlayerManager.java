package skejbydice.domain;

import org.junit.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPlayerManager {
    PlayerManagerImp playerManager;
    Player alpha;
    Player beta;

    @Before
    public void setUp() {
        alpha = new Player("Alpha");
        beta = new Player("Beta");
        playerManager = new PlayerManagerImp(new ChoseTheSamePlayerAlwaysStrategy(beta));
        playerManager.addPlayer(alpha);
        playerManager.addPlayer(beta);
    }

    @Test
    public void shouldReturnTheActivePlayer() {
        Assert.assertThat(playerManager.getCurrentPlayer(), is(alpha));
        playerManager.nextPlayer();
        Assert.assertThat(playerManager.getCurrentPlayer(), is(beta));
        playerManager.nextPlayer();
        Assert.assertThat(playerManager.getCurrentPlayer(), is(alpha));
    }
}
