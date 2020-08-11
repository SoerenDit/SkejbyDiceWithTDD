package test;

import main.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestPlayer {
    Player p;

    @BeforeEach
    public void setUp() {
        p = new Player("Søren");
    }

    @Test
    public void shouldIncreasePlayerSipsByOne() {
        p.drinkSips(1);
        assertThat(p.getSips(),is(1));
    }

    @Test
    public void shouldIncreasePlayerSipsByFour() {
        p.drinkSips(1);
        assertThat(p.getSips(),is(1));
        p.drinkSips(3);
        assertThat(p.getSips(),is(4));
    }

    @Test
    public void shouldIncreaseBeerByOneAndResetPlayerSipsToZeroByEmptying() {
        p.drinkSips(1);
        p.emptyBeer();
        assertThat(p.getNumberOfBeers(), is(1));
        assertThat(p.getSips(),is(0));
    }

    @Test
    public void shouldIncreaseBeerByOneAndResetPlayerSipsToZeroByDrinking16Sips() {
        p.drinkSips(16);
        assertThat(p.getNumberOfBeers(), is(1));
        assertThat(p.getSips(),is(0));
    }

    @Test
    public void shouldReturnPlayerName() {
        assertThat(p.getName(),is("Søren"));
    }



}
