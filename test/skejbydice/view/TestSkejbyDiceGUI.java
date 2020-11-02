package skejbydice.view;

import org.junit.Before;
import org.junit.Test;
import skejbydice.standard.factories.AlphaPlayerFactoy;
import skejbydice.standard.strategies.AlwaysDefendYourselfStrategy;
import skejbydice.standard.Game;
import skejbydice.standard.Player;
import skejbydice.standard.RegularDie;
import skejbydice.standard.strategies.ChosePlayerWithClickStrategy;
import skejbydice.standard.strategies.RandomRollStrategy;
import skejbydice.standard.strategies.RegularDecideNumberOfTurnsStrategy;

public class TestSkejbyDiceGUI {
    Game game;

    @Before
    public void setUp() {
        game = new Game(new RegularDecideNumberOfTurnsStrategy(), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()));
        game.addPlayer(new Player("Alpha", new AlphaPlayerFactoy()));
        game.addPlayer(new Player("Beta", new AlphaPlayerFactoy()));
    }

    @Test
    public void testGUI() throws InterruptedException {
        game.startGame();
        new SkejbyDiceGUI(game);
    }
}


