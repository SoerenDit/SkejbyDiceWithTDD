package skejbydice.domain;

public class NeverDefendYourselfStrategy implements DefenceStrategy {
    @Override
    public boolean willHeDefendHimself() {
        return false;
    }
}
