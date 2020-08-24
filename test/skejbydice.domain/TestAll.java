package skejbydice.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith ( Suite.class )
@Suite.SuiteClasses(
        { TestRegularDie.class,
                TestLuckyDie.class,
                TestPlayer.class,
                TestGame.class,
                TestAttackAndDefence.class,
                TestChosePlayerStrategy.class,
                TestPlayerManager.class
                } )


public class TestAll {
    // Dummy - it is the annotations that tell JUnit what to do...
}
