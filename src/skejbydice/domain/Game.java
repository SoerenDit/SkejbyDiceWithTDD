package skejbydice.domain;

public class Game {
    private PlayerManager playerManager;
    private DiceManager diceManager;
    private DecisionManager decisionManager;
    private gameState currentState;
    private String statusText;
    private boolean testing; //Only for testing purposes

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

    public Game(ChosePlayerStrategyI chosePlayerStrategy, RerollOrAttackStrategyI rerollOrAttackStrategy, DecideNumberOfTurnsStrategy decideNumberOfTurnsStrategy,
                RegularDie attackingDie1, RegularDie attackingDie2, RegularDie defendingDie) {
        diceManager = new DiceManager(attackingDie1, attackingDie2, defendingDie);
        playerManager = new PlayerManager();
        decisionManager = new DecisionManager(chosePlayerStrategy, rerollOrAttackStrategy, decideNumberOfTurnsStrategy);
        currentState = gameState.idle;
    }

    public void start(boolean testing) {
        this.testing = testing;
        currentState = gameState.start;
        gameFlow();
    }

    //****************** Game Flow ********************//
    public void gameFlow() {
        switch (currentState) {
            case start:
                onGameStarted();
                break;
            case turnStarted:
                onTurnStarted();
                break;
            case aboutToRollAttackingDice:
                onRollAttackingDice();
                break;
            case aboutToDecideWhetherToDrinkYourselfOrAttack:
                onDecideWhetherToDrinkYourselfOrAttack();
                break;
            case aboutToChosePlayerToAttack:
                onChosePlayerToAttack();
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

    public void onGameStarted() {
        statusText = "Turn started";
        currentState = gameState.turnStarted;
        print(statusText);
        gameFlow();
    }

    public void onTurnStarted() {
        statusText = "Turn started. Roll the attacking dice!";
        currentState = gameState.aboutToRollAttackingDice;
        if (testing) {
            print(statusText);
            gameFlow();
        }
    }

    public void onRollAttackingDice() {
        statusText = "Roll attacking dice";
        print(statusText);
        diceManager.rollAttackingDice();
        print("Attacking dice: " + diceManager.getAttackingDiceNumbers());
        if (diceManager.isItFirstAttackingRoll())
            print("This is the first attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        else
            print("This is the second attacking role, so you can give " + diceManager.getNumberOfSipsToGiveAway() + " sips away");
        currentState = gameState.aboutToDecideWhetherToDrinkYourselfOrAttack;
        gameFlow();
    }

    public void onDecideWhetherToDrinkYourselfOrAttack() {
        statusText = "Do you want to drink yourself or to attack?";
        print(statusText);
        if (decisionManager.willYouDrinkAndReroll()) {
            diceManager.setFirstAttackingRoll(false);
            currentState = gameState.aboutToRollAttackingDice;
            gameFlow();
        } else {
            currentState = gameState.aboutToChosePlayerToAttack;
            gameFlow();
        }
    }

    public void onChosePlayerToAttack() {
        statusText = "Chose player to attack";
        print(statusText);
        playerManager.setPlayerUnderAttack(decisionManager.chosePlayer());
        statusText = "Player under attack is: " + playerManager.getPlayerUnderAttack();
        print(statusText);
        currentState = gameState.aboutToRollDefendingDie;
        gameFlow();
    }

    public void onRollDefendingDie() {
        statusText = "Roll defending die";
        print(statusText);
        currentState = gameState.aboutToPunishLosingPlayer;
        gameFlow();
    }

    public void onPunishLosingPlayer() {
        statusText = "Punish losing player";
        print(statusText);
        currentState = gameState.aboutToStartNextPlayersTurn;
        gameFlow();
    }

    public void onStartNextPlayersTurn() {
        statusText = "Start next players turn";
        print(statusText);
        if (decisionManager.isThisTheLastTurn()) {
            currentState = gameState.gameFinished;
            gameFlow();
        } else {
            playerManager.nextPlayer();
            currentState = gameState.turnStarted;
            gameFlow();
        }
    }

    public void onGameFinished() {
        statusText = "Game finished";
        print(statusText);
    }


    // Helper methods
    private void print(String s) {
        System.out.println(s);
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

    public String getSipsFromActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();
        return "" + activePlayer.getSips();
    }

    public String getLuckyDieNumberFromActivePlayer() {
        Player activePlayer = playerManager.getCurrentPlayer();

        return "" + activePlayer.getLuckyDieNumber();
    }

    public String getStatusText() {
        return statusText;
    }


}
