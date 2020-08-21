package skejbydice.domain;

public class DiceManager {
    private Die attackingDie1;
    private Die attackingDie2;

    public DiceManager() {
        attackingDie1 = new Die();
        attackingDie2 = new Die();
    }

    public int getSumOfAttackingDice() {
        return attackingDie1.getNumber() + attackingDie2.getNumber();
    }

    public void setAttackingDice(int a, int b) throws InvalidDieNumberException {
        attackingDie1.setNumber(a);
        attackingDie2.setNumber(b);
    }
}
