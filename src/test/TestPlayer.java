package test;

import main.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestPlayer {
    Player p;

    @BeforeEach
    public void setUp() {
        p = new Player();
    }

    @Test
    public void shouldIncreasePlayerSipByOne() {
        p.drinkSips(1);
        assertThat(p.getSips(),is(1));
    }


}
