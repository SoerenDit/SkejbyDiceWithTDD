package skejbydice.domain;

import org.junit.Before;
import org.junit.Test;

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
        attackingDie1 = new RegularDie(new FixedNumberRollStrategy(3)); //Always rolls 3
        attackingDie2 = new RegularDie(new FixedNumberRollStrategy(6)); //Always rolls 6
        defendingDie = new RegularDie(new RandomRollStrategy());

        // This test game starts with Alfa rolling first, then rerolling once, and then attacking Beta. Stops after two turns.
        game = new Game(new ChoseTheSamePlayerAlwaysStrategy(beta), new RerollOnceStrategy(), new AlwaysDefendYourselfStrategy(), new AlwaysPlayTwoTurnsStrategy(), attackingDie1, attackingDie2, defendingDie);
        game.addPlayer(alpha);
        game.addPlayer(beta);
    }

    @Test
    public void shouldReturnTheIdleState() {
        assertThat(game.getCurrentState(), is(Game.gameState.idle));
    }

    @Test
    public void rollingTwiceShouldRoundUpSips() throws InvalidDieNumberException {
        game.start(false);
        game.onRollAttackingDice();
        assertThat(game.getAttackingValue(),is(4)); //First time rolling 3+6 gives 4 sips away
        game.onDecideWhetherToDrinkYourselfOrAttack();
        assertThat(game.getCurrentState(),is(Game.gameState.aboutToRollAttackingDice));
        game.onRollAttackingDice();
        assertThat(game.getAttackingValue(),is(5)); //Second time rolling 3+6 gives 5 sips away
    }

    @Test
    public void rollingTwiceShouldCauseAttackingPlayerToDrinkSips() throws InvalidDieNumberException {
        game.start(false);
        game.onRollAttackingDice();
        assertThat(game.getSipsFromActivePlayer(),is(0));
        game.onDecideWhetherToDrinkYourselfOrAttack();
        assertThat(game.getCurrentState(),is(Game.gameState.aboutToRollAttackingDice));
        game.onRollAttackingDice();
        assertThat(game.getSipsFromActivePlayer(),is(4)); //Second time rolling 3+6 gives 5 sips away
    }

    @Test
    public void ifDefendingPlayerChoosesToDrinkFrom6And3AttackHeShouldDrink4Sips () {
        game.start(true);
        game.onRollAttackingDice();
        game.setRerollOrAttackStrategy(new NeverRerollStrategy());

    }

}


