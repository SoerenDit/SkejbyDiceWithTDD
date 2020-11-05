package skejbydice.standard;

import org.junit.Before;
import org.junit.Test;
import skejbydice.standard.factories.AlphaPlayerFactory;
import skejbydice.standard.factories.BetaPlayerFactory;
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
        // Alpha players always rerolls once, attack the person to the left and always tries to defend himself.
        anders = new Player("Anders", new AlphaPlayerFactory());
        anna = new Player("Anna", new AlphaPlayerFactory());

        // Beta players never rerolls, attack the person to the left, and never defends themselves.
        bjarne = new Player("Bjarne", new BetaPlayerFactory());
        britta = new Player("Britta", new BetaPlayerFactory());

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
        game.decideWhetherToDrinkYourselfOrAttack();
        assertThat(game.getCurrentState(),is(Game.gameState.aboutToRollAttackingDice));
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
        game.decideWhetherToDrinkYourselfOrAttack();
        assertThat(game.getSipsFromActivePlayer(),is(4)); 
    }

    @Test
    public void ifDefendingPlayerChoosesToDrinkFrom6And3AttackHeShouldDrink4Sips () {
        game.addPlayer(bjarne); // Never rerolls
        game.addPlayer(britta); // Never defends himself
        game.startGame();
        game.rollAttackingDice();
        game.decideWhetherToDrinkYourselfOrAttack();
        game.chosePlayerToAttack();
        assertThat(game.getPlayerUnderAttack(),is(britta));
        game.onDecideIfAttackedPlayerShouldDefendHimself();
        game.onRollDefendingDie();
        game.onPunishLosingPlayer();
        assertThat(game.getSipsFromPlayerUnderAttack(),is(4));
    }
}


