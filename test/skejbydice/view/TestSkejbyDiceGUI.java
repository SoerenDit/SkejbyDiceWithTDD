package skejbydice.view;

import org.junit.Before;
import org.junit.Test;
import skejbydice.domain.*;

public class TestSkejbyDiceGUI {
    Game game;

    @Before
    public void setUp() {
        game = new Game(new ChosePlayerWithClickStrategy(), new RegularRerollOrAttackStrategy(), new RegularDecideNumberOfTurnsStrategy(), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()), new RegularDie(new RandomRollStrategy()));
        game.addPlayer(new Player("Alpha"));
        game.addPlayer(new Player("Beta"));
    }

    @Test
    public void testGUI() throws InterruptedException {
        game.start(false);
        new SkejbyDiceGUI(game);
    }

}


