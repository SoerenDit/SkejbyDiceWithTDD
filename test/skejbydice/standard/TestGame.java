package skejbydice.standard;

import org.junit.Before;
import org.junit.Test;
import skejbydice.standard.strategies.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TestGame {
    private Game game;
    private Player anders;
    private Player anna;
    private Player bjarne;
    private RegularDie attackingDie1;
    private RegularDie attackingDie2;
    private RegularDie defendingDie;

    @Before
    public void setUp() throws InvalidDieNumberException {
        anders = new Player("Anders");
        anna = new Player("Anna");
        bjarne = new Player("Bjarne");
        attackingDie1 = new RegularDie(new FixedNumberRollStrategy(3)); //Always rolls 3
        attackingDie2 = new RegularDie(new FixedNumberRollStrategy(6)); //Always rolls 6
        defendingDie = new RegularDie(new FixedNumberRollStrategy(3));

        game = new Game(10, attackingDie1, attackingDie2, defendingDie);
        game.addPlayer(anders);
        game.addPlayer(anna);
        game.addPlayer(bjarne);
    }

    @Test
    public void shouldReturnTheIdleState() {
        assertThat(game.getCurrentState(), is(Game.gameState.idle));
    }

    @Test
    public void firstPlayerAddedShouldStartTheGame() {
        assertThat(game.getPlayerInTurn(),is(anders));
    }

    @Test
    public void activePlayterShouldSwitchWhenNewTurnBegins() {
        game.nextTurn();
        assertThat(game.getPlayerInTurn(),is(anna));
        game.nextTurn();
        assertThat(game.getPlayerInTurn(),is(bjarne));
        game.nextTurn();
        assertThat(game.getPlayerInTurn(),is(anders));
    }

    @Test
    public void rollingTwiceShouldRoundUpSips() {
        game.startGame();
        game.rollAttackingDice();
        assertThat(game.getAttackingValue(),is(4)); //First time rolling 3+6 gives 4 sips away
        game.rollAttackingDice();
        assertThat(game.getAttackingValue(),is(5)); //Second time rolling 3+6 gives 5 sips away
    }

    @Test
    public void rollingTwiceShouldCauseAttackingPlayerToDrinkSips() {
        game.startGame();
        game.rollAttackingDice();
        assertThat(game.getSipsFromActivePlayer(),is(0));
        game.rollAttackingDice();
        assertThat(game.getSipsFromActivePlayer(),is(4)); 
    }

    @Test
    public void ifDefendingPlayerChoosesToDrinkFrom6And3AttackHeShouldDrink4Sips () {
        game.startGame();
        game.rollAttackingDice();
        game.attackPlayer(anna);
        assertThat(game.getPlayerUnderAttack(),is(anna));
        game.punishLosingPlayer();
        assertThat(game.getSipsFromPlayerUnderAttack(),is(4));
    }

    @Test
    public void ifDefendingPlayerFailsToDefendFromFrom6And3AttackHeShouldDrink5Sips () {
        game.startGame();
        game.rollAttackingDice();
        game.attackPlayer(anna);
        game.tryToDefendYourself(); //fails
        game.punishLosingPlayer();
        assertThat(game.getSipsFromPlayerUnderAttack(),is(5));
    }

    @Test
    public void ifDefendingPlacerSuccedsDefendingFrom6And3AttackAttackerShouldDrink1Sips() throws InvalidDieNumberException {
        game.startGame();
        game.rollAttackingDice();
        game.attackPlayer(anna);
        game.setDefenceDie(new RegularDie(new FixedNumberRollStrategy(6)));
        game.tryToDefendYourself(); //succeds
        game.punishLosingPlayer();
        assertThat(game.getSipsFromActivePlayer(),is(1));
        assertThat(game.getSipsFromPlayerUnderAttack(),is(0));
    }



}


