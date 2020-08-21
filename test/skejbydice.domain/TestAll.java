package skejbydice.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith ( Suite.class )
@Suite.SuiteClasses(
        { TestDie.class,
                TestPlayer.class,
                TestGame.class } )


public class TestAll {
    // Dummy - it is the annotations that tell JUnit what to do...
}
