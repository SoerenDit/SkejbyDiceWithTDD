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
        if(isItFirstAttackingRollThisRound) return (attackingDie1.getFaceUpNumber()+attackingDie2.getFaceUpNumber())/2;
        else return (attackingDie1.getFaceUpNumber()+attackingDie2.getFaceUpNumber()+1)/2;
    }

    public void setFirstAttackingRoll(boolean b) {
        isItFirstAttackingRollThisRound = b;
    }

    public String getAttackingDiceNumbers() {
        return "" + attackingDie1.getFaceUpNumber() + " and " + attackingDie2.getFaceUpNumber();
    }

    public boolean isDefenceSuccesful() {
        return defendingDie.getFaceUpNumber() >= attackingDie1.getFaceUpNumber() && defendingDie.getFaceUpNumber() >= attackingDie2.getFaceUpNumber();
    }


}
