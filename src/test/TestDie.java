package test;

import main.Die;
import org.junit.jupiter.api.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class TestDie {
    private Die d;

    @BeforeEach
    public void setUp() {
        d = new Die();
    }

    @Test
    public void shouldReturnDieNumber() {
        d.setNumber(4);
        assertThat(d.getNumber(),is(4));
    }

    @Test
    public void shouldRoll3To4OnAverage() {
        double sum = 0;
        for(int i = 1; i <= 100; i++) {
            d.roll();
            sum += d.getNumber();
        }
        assertThat(sum,closeTo(350,100));
    }
    
}
