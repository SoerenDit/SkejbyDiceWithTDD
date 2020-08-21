package skejbydice.domain;

public class DiceManagerImpForTest implements DiceManager {
    private Die attackingDie1;
    private Die attackingDie2;

    public DiceManagerImpForTest() {
        attackingDie1 = new FakeDie();
        attackingDie2 = new FakeDie();
    }

    public void setAttackingDice(int a, int b) throws InvalidDieNumberException {
        attackingDie1.setNumber(a);
        attackingDie2.setNumber(b);
    }

    @Override
    public int getSumOfAttackingDice() {
        return attackingDie1.getNumber() + attackingDie2.getNumber();
    }
}
