package skejbydice.standard;

import skejbydice.standard.RegularDie;

public class DiceManager {
    private RegularDie attackingDie1;
    private RegularDie attackingDie2;
    private RegularDie defendingDie;
    private boolean isItFirstAttackingRoll = true;


    public DiceManager(RegularDie attackingDie1, RegularDie attackingDie2, RegularDie defendingDie) {
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
        if(isItFirstAttackingRoll) return (attackingDie1.getFaceUpNumber()+attackingDie2.getFaceUpNumber())/2;
        else return (attackingDie1.getFaceUpNumber()+attackingDie2.getFaceUpNumber()+1)/2;
    }

    public void setFirstAttackingRoll(boolean b) {
        isItFirstAttackingRoll = b;
    }

    public boolean isItFirstAttackingRoll() {
        return isItFirstAttackingRoll;
    }

    public String getAttackingDiceNumbers() {
        return "" + attackingDie1.getFaceUpNumber() + " and " + attackingDie2.getFaceUpNumber();
    }

    public boolean isDefenceSuccesful() {
        return defendingDie.getFaceUpNumber() >= attackingDie1.getFaceUpNumber() && defendingDie.getFaceUpNumber() >= attackingDie2.getFaceUpNumber();
    }


}
