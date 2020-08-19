package skejbydice.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.Test;

@RunWith ( Suite.class )
@Suite.SuiteClasses(
        { TestDie.class,
                TestPlayer.class,
                TestGame.class } )


public class TestAll {
    // Dummy - it is the annotations that tell JUnit what to do...
}
