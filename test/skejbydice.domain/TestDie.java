package skejbydice.domain;

import org.junit.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestDie {
    private Die d;

    @Before
    public void setUp() {
        d = new Die();
    }

    @Test
    public void shouldReturnValidDieNumber() throws InvalidDieNumberException {
        d.setNumber(4);
        assertThat(d.getNumber(), is(4));
    }

    @Test
    public void shouldRejectDieNumberToBeSetTo7() {
        InvalidDieNumberException theException =
                assertThrows(InvalidDieNumberException.class, () -> d.setNumber(7));
        assertThat(theException.getMessage(), containsString("Invalid die number: " + 7));
    }

    @Test
    public void shouldRejectDieNumberToBeSetTo0() {
        InvalidDieNumberException theException =
                assertThrows(InvalidDieNumberException.class, () -> d.setNumber(0));
        assertThat(theException.getMessage(), containsString("Invalid die number: " + 0));
    }

    @Test
    public void shouldRoll3To4OnAverage() {
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            d.roll();
            sum += d.getNumber();
        }
        assertThat(sum, closeTo(350, 100));
    }

    @Test
    public void shouldRollBetweenOneAndSix() {
        int min = 10;
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            d.roll();
            int n = d.getNumber();
            if (n < min) min = n;
            if (n > max) max = n;
        }
        assertThat(min, is(1));
        assertThat(max, is(6));
    }
/**
 @Test public void shouldReturn5Sips() {
 Die d2 = new Die();
 d.setNumber();
 }
 **/
}
