package skejbydice.domain;

public class DiceManagerImpForTest implements DiceManager {
    private Die attackingDie1;
    private Die attackingDie2;
    private boolean firstAttackingRoll = true;

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

    @Override
    public void rollAttackingDice() {

    }

    @Override
    public int getNumberOfSipsToGiveAway() {
        if(firstAttackingRoll) return (attackingDie1.getNumber()+attackingDie2.getNumber())/2;
        else return (attackingDie1.getNumber()+attackingDie2.getNumber()+1)/2;
    }
}
