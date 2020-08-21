package skejbydice.domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private int currentPlayer;
    private gameState currentState;
    private boolean shouldWePlayAnotherTurn = false;

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
        currentState = gameState.idle;
    }

    public void start() {
        currentState = gameState.start;
        gameFlow();
    }

    //****************** Game Flow ********************//
    private void gameFlow() {
        switch (currentState) {
            case start: onGameStarted();
            case turnStarted: onTurnStarted();
            case aboutToRollAttackingDice: onRollAttackingDice();
            case aboutToChosePlayerToAttack: onChosePlayerToAttack();
            case aboutToRollDefendingDie: onRollDefendingDie();
            case aboutToPunishLosingPlayer: onPunishLosingPlayer();
            case aboutToStartNextPlayersTurn: onStartNextPlayersTurn();
            case gameFinished: onGameFinished();
        }
    }

    private void onGameStarted() {
        currentState = gameState.turnStarted;
    }

    private void onTurnStarted() {
        currentState = gameState.aboutToRollAttackingDice;
    }

    private void onRollAttackingDice() {
        currentState = gameState.aboutToChosePlayerToAttack;
    }

    private void onChosePlayerToAttack() {
        currentState = gameState.aboutToRollDefendingDie;
    }

    private void onRollDefendingDie() {
        currentState = gameState.aboutToPunishLosingPlayer;
    }

    private void onPunishLosingPlayer() {
        currentState = gameState.aboutToStartNextPlayersTurn;
    }

    private void onStartNextPlayersTurn() {
        if(shouldWePlayAnotherTurn) {
            nextPlayer();
            currentState = gameState.turnStarted;
        } else {
            currentState = gameState.gameFinished;
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
