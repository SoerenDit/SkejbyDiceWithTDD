package skejbydice.view;

import org.junit.Before;
import org.junit.Test;
import skejbydice.standard.strategies.AlwaysDefendYourselfStrategy;
import skejbydice.standard.Game;
import skejbydice.standard.Player;
import skejbydice.standard.RegularDie;
import skejbydice.standard.strategies.ChosePlayerWithClickStrategy;
import skejbydice.standard.strategies.RandomRollStrategy;
import skejbydice.standard.strategies.RegularDecideNumberOfTurnsStrategy;
import skejbydice.standard.strategies.RegularRerollOrAttackStrategy;

public class TestSkejbyDiceGUI {
    Game game;

    @Before
    public void setUp() {
        game = new Game(new ChosePlayerWithClickStrategy(), new RegularRerollOrAttackStrategy(), new AlwaysDefendYourselfStrategy(), new RegularDecideNumberOfTurnsStrategy(), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()));
        game.addPlayer(new Player("Alpha"));
        game.addPlayer(new Player("Beta"));
    }

    @Test
    public void testGUI() throws InterruptedException {
        game.start(false);
        new SkejbyDiceGUI(game);
    }

}


