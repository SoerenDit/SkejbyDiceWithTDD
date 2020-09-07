package skejbydice.domain;

public class AlwaysDefendYourselfStrategy implements DefenceStrategy {

    @Override
    public boolean willHeDefendHimself() {
        return true;
    }
}