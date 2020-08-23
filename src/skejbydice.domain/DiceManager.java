package skejbydice.domain;

public class DiceManager {
    private Die attackingDie1;
    private Die attackingDie2;
    private Die defendingDie;
    private boolean isItFirstAttackingRollThisRound = true;


    public DiceManager(Die attackingDie1, Die attackingDie2, Die defendingDie) {
        this.attackingDie1 = attackingDie1;
        this.attackingDie2 = attackingDie2;
        this.defendingDie = defendingDie;
    }

    public void rollAttackingDice() {
        attackingDie1.roll();
        attackingDie2.roll();
    }

    public void rollDefendingDice() {
        defendingDie.roll();
    }

    public int getNumberOfSipsToGiveAway() {
        if(isItFirstAttackingRollThisRound) return (attackingDie1.getNumber()+attackingDie2.getNumber())/2;
        else return (attackingDie1.getNumber()+attackingDie2.getNumber()+1)/2;
    }

    public void setFirstAttackingRoll(boolean b) {
        isItFirstAttackingRollThisRound = b;
    }

    public String getAttackingDiceNumbers() {
        return "" + attackingDie1.getNumber() + " and " + attackingDie2.getNumber();
    }

    public boolean isDefenceSuccesful() {
        return defendingDie.getNumber() >= attackingDie1.getNumber() && defendingDie.getNumber() >= attackingDie2.getNumber();
    }


}
