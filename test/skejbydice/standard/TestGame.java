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
    private Player britta;

    @Before
    public void setUp() throws InvalidDieNumberException {

        anders = new Player("Anders");
        anna = new Player("Anna");

        bjarne = new Player("Bjarne");
        britta = new Player("Britta");

        attackingDie1 = new RegularDie(new FixedNumberRollStrategy(3)); //Always rolls 3
        attackingDie2 = new RegularDie(new FixedNumberRollStrategy(6)); //Always rolls 6
        defendingDie = new RegularDie(new FixedNumberRollStrategy(3));

        game = new Game(2, attackingDie1, attackingDie2, defendingDie);

    }

    @Test
    public void shouldReturnTheIdleState() {
        assertThat(game.getCurrentState(), is(Game.gameState.idle));
    }

    @Test
    public void firstPlayerAddedShouldStartTheGame() {
        game.addPlayer(anders);
        game.addPlayer(anna);
        assertThat(game.getPlayerInTurn(),is(anders));
    }

    @Test
    public void rollingTwiceShouldRoundUpSips() {
        game.addPlayer(anders);
        game.addPlayer(anna);
        game.startGame();
        game.rollAttackingDice();
        assertThat(game.getAttackingValue(),is(4)); //First time rolling 3+6 gives 4 sips away
        game.rollAttackingDice();
        assertThat(game.getAttackingValue(),is(5)); //Second time rolling 3+6 gives 5 sips away
    }

    @Test
    public void rollingTwiceShouldCauseAttackingPlayerToDrinkSips() {
        game.addPlayer(anders);
        game.addPlayer(anna);
        game.startGame();
        game.rollAttackingDice();
        assertThat(game.getSipsFromActivePlayer(),is(0));
        game.rollAttackingDice();
        assertThat(game.getSipsFromActivePlayer(),is(4)); 
    }

    @Test
    public void ifDefendingPlayerChoosesToDrinkFrom6And3AttackHeShouldDrink4Sips () {
        game.addPlayer(bjarne);
        game.addPlayer(britta);
        game.startGame();
        game.rollAttackingDice();
        game.attackPlayer(britta);
        assertThat(game.getPlayerUnderAttack(),is(britta));
        game.punishLosingPlayer();
        assertThat(game.getSipsFromPlayerUnderAttack(),is(4));
    }
}


