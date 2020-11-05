package skejbydice.standard;

import org.junit.*;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;


public class TestPlayerManager {
    PlayerManager playerManager;
    Player alpha;
    Player beta;

    @Before
    public void setUp() {
        alpha = new Player("Alpha");
        beta = new Player("Beta");
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
