package skejbydice.domain;

public class DiceManagerImp {
    private Die attackingDie1;
    private Die attackingDie2;
    private boolean firstAttackingRoll = true;

    public DiceManagerImp() {
        attackingDie1 = new Die();
        attackingDie2 = new Die();
    }

    public int getSumOfAttackingDice() {
        return attackingDie1.getNumber() + attackingDie2.getNumber();
    }

    public void rollAttackingDice() {

    }

    public int getNumberOfSipsToGiveAway() {
        if(firstAttackingRoll) return (attackingDie1.getNumber()+attackingDie2.getNumber())/2;
        else return (attackingDie1.getNumber()+attackingDie2.getNumber()+1)/2;
    }

    public void setAttackingDice(int a, int b) throws InvalidDieNumberException {
        attackingDie1.setNumber(a);
        attackingDie2.setNumber(b);
    }
}
