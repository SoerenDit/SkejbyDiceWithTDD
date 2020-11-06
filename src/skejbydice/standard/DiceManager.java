package skejbydice.standard;


import skejbydice.framework.DieI;

public class DiceManager {
    private DieI attackingDie1;
    private DieI attackingDie2;
    private DieI defendingDie;
    private int numberOfAttackRolls = 0;
    private boolean hasDefended = false;

    public DiceManager(RegularDie attackingDie1, RegularDie attackingDie2, RegularDie defendingDie) {
        this.attackingDie1 = attackingDie1;
        this.attackingDie2 = attackingDie2;
        this.defendingDie = defendingDie;
    }

    public void rollAttackingDice() {
        attackingDie1.roll();
        attackingDie2.roll();
        numberOfAttackRolls++;
    }

    public void rollDefenceDie() {
        defendingDie.roll();
        hasDefended = true;
    }

    public int getNumberOfSipsToGiveAway() {
        if(numberOfAttackRolls == 1) return (attackingDie1.getFaceUpNumber()+attackingDie2.getFaceUpNumber())/2;
        else return (attackingDie1.getFaceUpNumber()+attackingDie2.getFaceUpNumber()+1)/2;
    }

    public boolean hasDefended() { return hasDefended; }

    public boolean isItFirstAttackingRoll() {
        return numberOfAttackRolls == 0;
    }

    public boolean isDefenceSuccesful() {
        return defendingDie.getFaceUpNumber() >= attackingDie1.getFaceUpNumber() && defendingDie.getFaceUpNumber() >= attackingDie2.getFaceUpNumber();
    }

    public boolean wasDefenceSuccesfull() {
        if(defendingDie.getFaceUpNumber() == 0) return false;
        if(defendingDie.getFaceUpNumber() >= Math.max(attackingDie1.getFaceUpNumber(),attackingDie2.getFaceUpNumber())) return true;
        else return false;
    }

    public void setDefenceDie(DieI die) {
        defendingDie = die;
    }

    public void reset() {
        numberOfAttackRolls = 0;
        hasDefended = false;
    }
}
