package skejbydice.domain;

public class DiceManagerImp implements DiceManager {
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

    @Override
    public void rollAttackingDice() {

    }

    @Override
    public int getNumberOfSipsToGiveAway() {
        if(firstAttackingRoll) return (attackingDie1.getNumber()+attackingDie2.getNumber())/2;
        else return (attackingDie1.getNumber()+attackingDie2.getNumber()+1)/2;
    }

}
