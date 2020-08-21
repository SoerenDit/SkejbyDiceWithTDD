package skejbydice.domain;

public class DiceManagerImp implements DiceManager {
    private Die attackingDie1;
    private Die attackingDie2;

    public DiceManagerImp() {
        attackingDie1 = new Die();
        attackingDie2 = new Die();
    }

    public int getSumOfAttackingDice() {
        return attackingDie1.getNumber() + attackingDie2.getNumber();
    }

}
