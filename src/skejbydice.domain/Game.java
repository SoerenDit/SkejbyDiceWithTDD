package skejbydice.domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int currentPlayer;
    private gameState currentState;
    private boolean isThisTheLastTurn = true;
    private boolean testing; //Only for testing purposes
    private DiceManager diceManager;
    private ChosePlayerStrategy chosePlayerStrategy;
    private Player playerUnderAttack;

    public enum gameState {
        idle,
        start,
        turnStarted,
        aboutToRollAttackingDice,
        aboutToChosePlayerToAttack,
        aboutToRollDefendingDie,
        aboutToPunishLosingPlayer,
        aboutToStartNextPlayersTurn,
        gameFinished
    }

    public Game(ChosePlayerStrategy chosePlayerStrategy) {

        players = new ArrayList<Player>();
        currentPlayer = 0;
        diceManager = new DiceManager();
        currentState = gameState.idle;
        this.chosePlayerStrategy = chosePlayerStrategy;
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
        print("This is the first attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        currentState = gameState.aboutToChosePlayerToAttack;
        gameFlow();
    }

    private void onChosePlayerToAttack() {
        print("Chose player to attack");
        playerUnderAttack = chosePlayerStrategy.chosePlayer();
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
            nextPlayer();
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
        players.add(p);
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public Player whoseTurnIsIt() {
        return players.get(currentPlayer);
    }

    public void nextPlayer() {
        if(currentPlayer + 1 < players.size()) currentPlayer++;
        else currentPlayer = 0;
    }

    public Object getCurrentState() {
        return currentState;
    }

    public Player getPlayerUnderAttack() {
        return playerUnderAttack;
    }
}
