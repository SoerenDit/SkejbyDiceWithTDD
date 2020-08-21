package skejbydice.domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int currentPlayer;
    private gameState currentState;
    private boolean shouldWePlayAnotherTurn = false;
    private Die attackingDie1;
    private Die attackingDie2;

    public int getSumOfAttackingDice() {
        return attackingDie1.getNumber() + attackingDie2.getNumber();
    }

    public void setAttackingDice(int a, int b) throws InvalidDieNumberException {
        attackingDie1.setNumber(a);
        attackingDie2.setNumber(b);
    }

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

    public Game() {
        players = new ArrayList<Player>();
        currentPlayer = 0;
        attackingDie1 = new Die();
        attackingDie2 = new Die();
        currentState = gameState.idle;
    }

    public void start() {
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
        currentState = gameState.turnStarted;
        gameFlow();
    }

    private void onTurnStarted() {
        currentState = gameState.aboutToRollAttackingDice;
        gameFlow();
    }

    private void onRollAttackingDice() {

        currentState = gameState.aboutToChosePlayerToAttack;
        gameFlow();
    }

    private void onChosePlayerToAttack() {
        currentState = gameState.aboutToRollDefendingDie;
        gameFlow();
    }

    private void onRollDefendingDie() {
        currentState = gameState.aboutToPunishLosingPlayer;
        gameFlow();
    }

    private void onPunishLosingPlayer() {
        currentState = gameState.aboutToStartNextPlayersTurn;
        gameFlow();
    }

    private void onStartNextPlayersTurn() {
        if(shouldWePlayAnotherTurn) {
            nextPlayer();
            currentState = gameState.turnStarted;
            gameFlow();
        } else {
            currentState = gameState.gameFinished;
            gameFlow();
        }
    }

    private void onGameFinished() {
    }


    // Helper methods

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
}
