package skejbydice.domain;

import java.util.ArrayList;

public class Game {
    private GameManager gameManager;
    private PlayerManagerImp playerManager;
    private gameState currentState;
    private boolean isThisTheLastTurn = true;
    private boolean testing; //Only for testing purposes
    private DiceManager diceManager;
    private Player playerUnderAttack;

    private int rerollNumber;
    private int maxRerollNunber;

    public enum gameState {
        idle,
        start,
        turnStarted,
        aboutToRollAttackingDice,
        aboutToDecideWhetherToDrinkYourselfOrAttack,
        aboutToChosePlayerToAttack,
        aboutToRollDefendingDie,
        aboutToPunishLosingPlayer,
        aboutToStartNextPlayersTurn,
        gameFinished
    }

    public Game(ChosePlayerStrategy chosePlayerStrategy, RegularDie attackingDie1, RegularDie attackingDie2, RegularDie defendingDie) {
        rerollNumber = 0;
        maxRerollNunber = 1;
        diceManager = new DiceManager(attackingDie1, attackingDie2, defendingDie);
        gameManager = new GameManager();
        playerManager = new PlayerManagerImp(chosePlayerStrategy);
        currentState = gameState.idle;
    }

    public void start(boolean testing) {
        this.testing = testing;
        currentState = gameState.start;
        gameFlow();
    }

    //****************** Game Flow ********************//
    private void gameFlow() {
        switch (currentState) {
            case start: onGameStarted(); break;
            case turnStarted: onTurnStarted(); break;
            case aboutToRollAttackingDice: onRollAttackingDice(); break;
            case aboutToDecideWhetherToDrinkYourselfOrAttack: onDecideWhetherToDrinkYourselfOrAttack(); break;
            case aboutToChosePlayerToAttack: onChosePlayerToAttack(); break;
            case aboutToRollDefendingDie: onRollDefendingDie(); break;
            case aboutToPunishLosingPlayer: onPunishLosingPlayer(); break;
            case aboutToStartNextPlayersTurn: onStartNextPlayersTurn(); break;
            case gameFinished: onGameFinished(); break;
        }
    }

    private void onGameStarted() {
        print("Game started");
        currentState = gameState.turnStarted;
        gameFlow();
    }

    private void onTurnStarted() {
        print("Turn started");
        currentState = gameState.aboutToRollAttackingDice;
        gameFlow();
    }

    private void onRollAttackingDice() {
        print("Roll attacking dice");
        diceManager.rollAttackingDice();
        print("Attacking dice: " + diceManager.getAttackingDiceNumbers());
        if(diceManager.isItFirstAttackingRoll()) print("This is the first attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        else print("This is the second attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        currentState = gameState.aboutToDecideWhetherToDrinkYourselfOrAttack;
        gameFlow();
    }

    private void onDecideWhetherToDrinkYourselfOrAttack() {
        print("Do you want to drink yourself or to attack?");
        if(gameManager.doYouWantToDrinkTheSipsYourself() && rerollNumber < maxRerollNunber) {
            rerollNumber++;
            diceManager.setFirstAttackingRoll(false);
            currentState = gameState.aboutToRollAttackingDice;
            gameFlow();
        } else {
            currentState = gameState.aboutToChosePlayerToAttack;
            gameFlow();
        }
    }

    private void onChosePlayerToAttack() {
        print("Chose player to attack");
        playerUnderAttack = playerManager.chosePlayer();
        print("Player under attack is: " + playerUnderAttack.getName());
        currentState = gameState.aboutToRollDefendingDie;
        gameFlow();
    }

    private void onRollDefendingDie() {
        print("Roll defending die");
        currentState = gameState.aboutToPunishLosingPlayer;
        gameFlow();
    }

    private void onPunishLosingPlayer() {
        print("Punish losing player");
        currentState = gameState.aboutToStartNextPlayersTurn;
        gameFlow();
    }

    private void onStartNextPlayersTurn() {
        print("Start next players turn");
        if(isThisTheLastTurn) {
            currentState = gameState.gameFinished;
            gameFlow();
        } else {
            playerManager.nextPlayer();
            currentState = gameState.turnStarted;
            gameFlow();

        }
    }

    private void onGameFinished() {
        print("Game finished");
    }


    // Helper methods

    private void print(String s) {
        if(testing) System.out.println(s);
    }

    public void addPlayer(Player p) {
        playerManager.addPlayer(p);
    }

    public Object getCurrentState() {
        return currentState;
    }

    public Player getPlayerUnderAttack() {
        return playerUnderAttack;
    }
}
