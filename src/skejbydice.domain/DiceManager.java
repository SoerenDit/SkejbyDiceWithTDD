package skejbydice.domain;

public class DiceManager {
    private Die attackingDie1;
    private Die attackingDie2;
    private boolean isItFirstAttackingRollThisRound = true;
    private Die defendingDie;

    public DiceManager() {
        attackingDie1 = new Die();
        attackingDie2 = new Die();
        defendingDie = new Die();
    }

    public int getSumOfAttackingDice() {
        return attackingDie1.getNumber() + attackingDie2.getNumber();
    }

    public void rollAttackingDice() {
        attackingDie1.roll();
        attackingDie2.roll();
    }

    public int getNumberOfSipsToGiveAway() {
        if(isItFirstAttackingRollThisRound) return (attackingDie1.getNumber()+attackingDie2.getNumber())/2;
        else return (attackingDie1.getNumber()+attackingDie2.getNumber()+1)/2;
    }

    public void setAttackingDice(int a, int b) throws InvalidDieNumberException {
        attackingDie1.setNumber(a);
        attackingDie2.setNumber(b);
    }

    public void setFirstAttackingRoll(boolean b) {
        isItFirstAttackingRollThisRound = b;
    }

    public String getAttackingDiceNumbers() {
        return "" + attackingDie1.getNumber() + " and " + attackingDie2.getNumber();
    }

    public void setDefendingDie(int n) throws InvalidDieNumberException {
        defendingDie.setNumber(n);
    }

    public boolean isDefenceSuccesful() {
        return defendingDie.getNumber() >= attackingDie1.getNumber() && defendingDie.getNumber() >= attackingDie2.getNumber();
    }
}
