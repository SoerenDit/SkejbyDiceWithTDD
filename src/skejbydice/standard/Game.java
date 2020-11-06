package skejbydice.standard;

import skejbydice.framework.DieI;

public class Game {
    private PlayerManager playerManager;
    private DiceManager diceManager;
    private gameState currentState;
    private String statusText;
    private boolean print = true; //Only for testing purposes
    private int currentTurn;
    private int turnsToPlay;

    public Player getPlayerInTurn() {
        return playerManager.getCurrentPlayer();
    }

    public void setDefenceDie(DieI die) {
        diceManager.setDefenceDie(die);
    }

    public enum gameState {
        idle,
        gameStarted,
        turnStarted,
        aboutToRollAttackingDice,
        attackingDiceRolled,
        playerHasBeenAttacked,
        playerIsDefending,
        playerHasBeenPunished,
        gameFinished
    }

    public Game(int turnsToPlay,
                RegularDie attackingDie1, RegularDie attackingDie2, RegularDie defendingDie) {
        diceManager = new DiceManager(attackingDie1, attackingDie2, defendingDie);
        playerManager = new PlayerManager();
        currentTurn = 1;
        this.turnsToPlay = turnsToPlay;
        currentState = gameState.idle;
    }

    //****************** Game Flow ********************//
    /**
    public void gameFlow() {
        switch (currentState) {
            case start:
                startGame();
                break;
            case turnStarted:
                startTurn();
                break;
            case aboutToRollAttackingDice:
                rollAttackingDice();
                break;
            case aboutToDecideWhetherToDrinkYourselfOrAttack:
                decideWhetherToDrinkYourselfOrAttack();
                break;
            case aboutToChosePlayerToAttack:
                chosePlayerToAttack();
                break;
            case aboutToDecideIfAttackedPlayerShouldDefendHimself:
                onDecideIfAttackedPlayerShouldDefendHimself();
                break;
            case aboutToRollDefendingDie:
                onRollDefendingDie();
                break;
            case aboutToPunishLosingPlayer:
                onPunishLosingPlayer();
                break;
            case aboutToStartNextPlayersTurn:
                onStartNextPlayersTurn();
                break;
            case gameFinished:
                onGameFinished();
                break;
        }
    }
     */
    public void startGame() {
        statusText = "Game started";
        currentState = gameState.gameStarted;
        print(statusText);
    }

    public void rollAttackingDice() {
        if(! diceManager.isItFirstAttackingRoll()) {
            playerManager.increaseActivePlayerSips(diceManager.getNumberOfSipsToGiveAway());

        }
        statusText = "Roll attacking dice";
        diceManager.rollAttackingDice();
        if (diceManager.isItFirstAttackingRoll())
            print("This is the first attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        else
            print("This is the second attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        currentState = gameState.attackingDiceRolled;

    }

    public void attackPlayer(Player player) {
        statusText = "Chose player to attack";
        print(statusText);
        playerManager.setPlayerUnderAttack(player);
        statusText = "Player under attack is: " + player;
        print(statusText);
        currentState = gameState.playerHasBeenAttacked;
    }

    public void tryToDefendYourself() {
        statusText = "Roll defending die";
        diceManager.rollDefenceDie();
        currentState = gameState.playerIsDefending;
    }

    public void punishLosingPlayer() {
        Player attacker = playerManager.getCurrentPlayer();
        Player defender = playerManager.getPlayerUnderAttack();

        if(! diceManager.hasDefended()) {
            playerManager.makePlayerDrink(defender,diceManager.getNumberOfSipsToGiveAway());
        } else if (diceManager.wasDefenceSuccesfull()) {
            playerManager.makePlayerDrink(attacker,1);
        } else { // Tried to defend but did not succed
            playerManager.makePlayerDrink(defender,diceManager.getNumberOfSipsToGiveAway()+1);
            defender.increaseLuckyDie();
        }
        currentState = gameState.playerHasBeenPunished;
    }

    public void nextTurn() {
        statusText = "Start next players turn";
        print(statusText);
        if (currentTurn == turnsToPlay) {
            currentState = gameState.gameFinished;
        } else {
            resetStuff();
            currentTurn++;
            playerManager.nextPlayer();
            currentState = gameState.turnStarted;
        }
    }

    private void resetStuff() {
        diceManager.reset();
    }

    public void onGameFinished() {
        statusText = "Game finished";
        print(statusText);
    }


    // Helper methods
    private void print(String s) {

        if(print) System.out.println(s);
    }

    public gameState getCurrentState() {
        return currentState;
    }


    // Methods for communicating with GUI
    public String getNameOfActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();
        return activePlayer.getName();
    }

    public void addPlayer(Player p) {
        playerManager.addPlayer(p);
    }

    public String getBeerFromActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();
        return "" + activePlayer.getNumberOfBeers();
    }

    public int getSipsFromActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();
        return activePlayer.getSips();
    }

    public int getLuckyDieNumberFromActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();
        return activePlayer.getLuckyDieNumber();
    }

    public String getStatusText() {
        return statusText;
    }

    public int getAttackingValue() {
        return diceManager.getNumberOfSipsToGiveAway();
    }

    public Player getPlayerUnderAttack() {
        return playerManager.getPlayerUnderAttack();
    }

    public int getSipsFromPlayerUnderAttack() {
        return playerManager.getPlayerUnderAttack().getSips();
    }
}
