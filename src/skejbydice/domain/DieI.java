package skejbydice.domain;

public interface DieI {
    void roll();
    int getFaceUpNumber();
    void changeRollStrategy(DieRollStrategyI dieRollStrategy);
}
