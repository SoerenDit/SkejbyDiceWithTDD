package skejbydice.domain;

import org.junit.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestRegularDie {
    private RegularDie dRandom;

    @Before
    public void setUp() throws InvalidDieNumberException {
        dRandom = new RegularDie(new RandomRollStrategy());
    }

    @Test
    public void shouldReturnValidDieNumber() throws InvalidDieNumberException {
        RegularDie d4 = new RegularDie(new FixedNumberRollStrategy(4));
        d4.roll();
        assertThat(d4.getFaceUpNumber(), is(4));
    }
/*
    @Test
    public void shouldRejectDieNumberToBeSetTo7() {
        InvalidDieNumberException theException =
                assertThrows(InvalidDieNumberException.class, () -> d4.setNumber(7));
        assertThat(theException.getMessage(), containsString("Invalid die number: " + 7));
    }

    @Test
    public void shouldRejectDieNumberToBeSetTo0() {
        InvalidDieNumberException theException =
                assertThrows(InvalidDieNumberException.class, () -> d4.setNumber(0));
        assertThat(theException.getMessage(), containsString("Invalid die number: " + 0));
    }
*/

    @Test
    public void shouldRoll3To4OnAverage() {
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            dRandom.roll();
            sum += dRandom.getFaceUpNumber();
        }
        assertThat(sum, closeTo(350, 100));
    }

    @Test
    public void shouldRollBetweenOneAndSix() {
        int min = 10;
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            dRandom.roll();
            int n = dRandom.getFaceUpNumber();
            if (n < min) min = n;
            if (n > max) max = n;
        }
        assertThat(min, is(1));
        assertThat(max, is(6));
    }

}
