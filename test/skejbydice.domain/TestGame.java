package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TestGame {
    private Game game;
    private Player alpha;
    private Player beta;

    @Before
    public void setUp() {
        alpha = new Player("Alpha");
        beta = new Player("Beta");
        RegularDie randomDie = new RegularDie(new RandomRollStrategy());
        game = new Game(new ChoseTheSamePlayerAlwaysStrategy(beta), randomDie, randomDie, randomDie);
        game.addPlayer(alpha);
        game.addPlayer(beta);
    }

    @Test
    public void shouldReachTheGameEndedState() {
        game.start(true);
        assertThat(game.getCurrentState(), is(Game.gameState.gameFinished));
    }

    @Test
    public void shouldAddTwoPlayersToGame() {
        assertThat(game.getPlayer(0), is(alpha));
        assertThat(game.getPlayer(1), is(beta));
    }

    @Test
    public void shouldReturnTheActivePlayer() {
        assertThat(game.whoseTurnIsIt(), is(alpha));
        game.nextPlayer();
        assertThat(game.whoseTurnIsIt(), is(beta));
        game.nextPlayer();
        assertThat(game.whoseTurnIsIt(), is(alpha));
    }

    @Test
    public void shouldReturnThePlayerUnderAttack() {
        game.start(false);
        assertThat(game.getPlayerUnderAttack(), is(beta));
    }

    @Test
    public void shouldReturnTheIdleState() {
        assertThat(game.getCurrentState(), is(Game.gameState.idle));
    }

}


