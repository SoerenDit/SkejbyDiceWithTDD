package skejbydice.standard;

import skejbydice.framework.strategies.ChosePlayerStrategyI;
import skejbydice.framework.strategies.DecideNumberOfTurnsStrategy;
import skejbydice.framework.strategies.DefenceStrategy;
import skejbydice.framework.strategies.RerollOrAttackStrategyI;

public class Game {
    private PlayerManager playerManager;
    private DiceManager diceManager;
    private DecisionManager decisionManager;
    private gameState currentState;
    private String statusText;
    private boolean print = true; //Only for testing purposes
    private int noOfSipsToLosingPlayer;

    public void setRerollOrAttackStrategy(RerollOrAttackStrategyI rerollOrAttackStrategy) {
        decisionManager.setRerollOrAttackStrategy(rerollOrAttackStrategy);
    }

    public enum gameState {
        idle,
        gameStarted,
        turnStarted,
        aboutToRollAttackingDice,
        aboutToDecideWhetherToDrinkYourselfOrAttack,
        aboutToChosePlayerToAttack,
        aboutToDecideIfAttackedPlayerShouldDefendHimself,
        aboutToRollDefendingDie,
        aboutToPunishLosingPlayer,
        aboutToStartNextPlayersTurn,
        gameFinished
    }

    public Game(ChosePlayerStrategyI chosePlayerStrategy, RerollOrAttackStrategyI rerollOrAttackStrategy, DefenceStrategy defenceStrategy, DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy,
                RegularDie attackingDie1, RegularDie attackingDie2, RegularDie defendingDie) {
        diceManager = new DiceManager(attackingDie1, attackingDie2, defendingDie);
        playerManager = new PlayerManager();
        decisionManager = new DecisionManager(chosePlayerStrategy, rerollOrAttackStrategy, defenceStrategy, decideNumberOfTurnsStrategy);
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

    public void startTurn() {
        statusText = "Turn started. Roll the attacking dice!";
        currentState = gameState.aboutToRollAttackingDice;
        print(statusText);

    }

    public void rollAttackingDice() {
        statusText = "Roll attacking dice";
        print(statusText);
        diceManager.rollAttackingDice();
        print("Attacking dice: " + diceManager.getAttackingDiceNumbers());
        if (diceManager.isItFirstAttackingRoll())
            print("This is the first attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        else
            print("This is the second attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        currentState = gameState.aboutToDecideWhetherToDrinkYourselfOrAttack;
    }

    public void decideWhetherToDrinkYourselfOrAttack() {
        statusText = "Do you want to drink yourself or to attack?";
        print(statusText);
        if (decisionManager.willYouDrinkAndReroll()) {
            playerManager.increaseActivePlayerSips(diceManager.getNumberOfSipsToGiveAway());
            diceManager.setFirstAttackingRoll(false);
            currentState = gameState.aboutToRollAttackingDice;
        } else {
            currentState = gameState.aboutToChosePlayerToAttack;
        }
    }

    public void chosePlayerToAttack() {
        statusText = "Chose player to attack";
        print(statusText);
        playerManager.setPlayerUnderAttack(decisionManager.chosePlayer());
        statusText = "Player under attack is: " + playerManager.getPlayerUnderAttack().getName();
        print(statusText);
        currentState = gameState.aboutToDecideIfAttackedPlayerShouldDefendHimself;
    }

    public void onDecideIfAttackedPlayerShouldDefendHimself() {
        statusText = playerManager.getPlayerUnderAttack() + ", will you defend yourself?";
        if(decisionManager.willAttackedPlayerDefendHimself()) {
            currentState = gameState.aboutToRollDefendingDie;
        } else {
            playerManager.setLosingPlayer(playerManager.getPlayerUnderAttack());
            noOfSipsToLosingPlayer = diceManager.getNumberOfSipsToGiveAway();
            currentState = gameState.aboutToPunishLosingPlayer;
        }
    }

    public void onRollDefendingDie() {
        statusText = "Roll defending die";
        print(statusText);
        currentState = gameState.aboutToPunishLosingPlayer;
    }

    public void onPunishLosingPlayer() {
        statusText = playerManager.getLosingPlayer().getName() + " must drink " + noOfSipsToLosingPlayer + " sips";
        playerManager.punishLosingPlayer(noOfSipsToLosingPlayer);
        print(statusText);
        currentState = gameState.aboutToStartNextPlayersTurn;
    }

    public void onStartNextPlayersTurn() {
        statusText = "Start next players turn";
        print(statusText);
        if (decisionManager.isThisTheLastTurn()) {
            currentState = gameState.gameFinished;
        } else {
            playerManager.nextPlayer();
            currentState = gameState.turnStarted;
        }
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

    public String getLuckyDieNumberFromActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();

        return "" + activePlayer.getLuckyDieNumber();
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
