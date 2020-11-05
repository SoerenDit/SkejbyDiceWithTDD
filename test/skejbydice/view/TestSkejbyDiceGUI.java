package skejbydice.view;

import org.junit.Before;
import org.junit.Test;
import skejbydice.standard.Game;
import skejbydice.standard.Player;
import skejbydice.standard.RegularDie;
import skejbydice.standard.strategies.RandomRollStrategy;

public class TestSkejbyDiceGUI {
    Game game;

    @Before
    public void setUp() {
        game = new Game(2, new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()));
        game.addPlayer(new Player("Alpha"));
        game.addPlayer(new Player("Beta"));
    }

    @Test
    public void testGUI() throws InterruptedException {
        game.startGame();
        new SkejbyDiceGUI(game);
    }
}


