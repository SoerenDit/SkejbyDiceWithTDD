package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TestGame {
    private Game game;
    private Player alpha;
    private Player beta;
    private RegularDie attackingDie1;
    private RegularDie attackingDie2;
    private RegularDie defendingDie;

    @Before
    public void setUp() throws InvalidDieNumberException {
        alpha = new Player("Alpha");
        beta = new Player("Beta");
        attackingDie1 = new RegularDie(new RandomRollStrategy());
        attackingDie2 = new RegularDie(new RandomRollStrategy());
        defendingDie = new RegularDie(new RandomRollStrategy());
        game = new Game(new ChoseTheSamePlayerAlwaysStrategy(beta), new AlwaysRerollOnceStrategy(), new AlwaysPlayTwoTurnsStrategy(), attackingDie1, attackingDie2, defendingDie);
        game.addPlayer(alpha);
        game.addPlayer(beta);
    }

    @Test
    public void shouldReturnTheIdleState() {
        assertThat(game.getCurrentState(), is(Game.gameState.idle));
    }

    @Test
    public void rollingTwiceShouldRoundUpSips() throws InvalidDieNumberException {
        attackingDie1.changeRollStrategy(new FixedNumberRollStrategy(3));
        attackingDie2.changeRollStrategy(new FixedNumberRollStrategy(6));
        game.start(false);
        game.onGameStarted();
        game.onTurnStarted();
        game.onRollAttackingDice();
        assertThat(game.getAttackingValue(),is(4));
        game.onDecideWhetherToDrinkYourselfOrAttack();
    }


/*
    @Test
    public void shouldReachTheGameEndedState() {
        game.start(true);
        assertThat(game.getCurrentState(), is(Game.gameState.gameFinished));
    }

 */







}


