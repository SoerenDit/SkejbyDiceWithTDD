package skejbydice.standard;

import org.junit.*;
import org.junit.Test;
import skejbydice.standard.factories.AlphaPlayerFactoy;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestPlayerManager {
    PlayerManager playerManager;
    Player alpha;
    Player beta;

    @Before
    public void setUp() {
        alpha = new Player("Alpha", new AlphaPlayerFactoy());
        beta = new Player("Beta", new AlphaPlayerFactoy());
        playerManager = new PlayerManager();
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
    @Test
    public void shouldReturnThePlayerUnderAttack() {
        playerManager.setPlayerUnderAttack(beta);
        Assert.assertThat(playerManager.getPlayerUnderAttack(), is(beta));
    }
}
