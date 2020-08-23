package skejbydice.domain;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLuckyDie {
    private LuckyDie lucky;

    @Before
    public void setUp() {
        lucky = new LuckyDie(new RandomRollStrategy());
    }

    @Test
    public void shouldIncreaseLuckyDieByOne() {
        assertThat(lucky.getNumber(), is(1));
        lucky.increaseByOne();
        assertThat(lucky.getNumber(),is(2));
    }

    @Test
    public void shouldBeUnableToIncreaseNumberToMoreThanSix() {
        lucky.increaseByOne();
        lucky.increaseByOne();
        lucky.increaseByOne();
        lucky.increaseByOne();
        lucky.increaseByOne();
        assertThat(lucky.getNumber(),is(6));
        lucky.increaseByOne();
        assertThat(lucky.getNumber(),is(6));
    }

    @Test
    public void shouldDecreaseLuckyDieByOne() {
        lucky.increaseByOne();
        assertThat(lucky.getNumber(), is(2));
        lucky.decreaseByOne();
        assertThat(lucky.getNumber(),is(1));
    }

    @Test
    public void shouldBeUnableToDecreaseNumberToLessThanSix() {
        assertThat(lucky.getNumber(),is(1));
        lucky.decreaseByOne();
        assertThat(lucky.getNumber(),is(1));
    }

}
