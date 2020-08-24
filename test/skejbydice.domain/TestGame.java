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
        RegularDie attackingDie1 = new RegularDie(new RandomRollStrategy());
        RegularDie attackingDie2 = new RegularDie(new RandomRollStrategy());
        RegularDie defendingDie = new RegularDie(new RandomRollStrategy());
        game = new Game(new ChoseTheSamePlayerAlwaysStrategy(beta), new AlwaysRerollOnceStrategy(), new AlwaysPlayTwoTurnsStrategy(), attackingDie1, attackingDie2, defendingDie);
        game.addPlayer(alpha);
        game.addPlayer(beta);
    }

    @Test
    public void shouldReachTheGameEndedState() {
        game.start(true);
        assertThat(game.getCurrentState(), is(Game.gameState.gameFinished));
    }



    @Test
    public void shouldReturnTheIdleState() {
        assertThat(game.getCurrentState(), is(Game.gameState.idle));
    }



}


