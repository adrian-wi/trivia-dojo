package com.adaptionsoft.games.trivia.game;

import com.adaptionsoft.games.trivia.Player;

public class AnswerResolver {

    private static final int MAX_COINS_AMOUNT = 6;

    private PlayerTurnHandler playerTurnHandler;
    private MessageHandler messageHandler;

    public AnswerResolver(PlayerTurnHandler playerTurnHandler) {
        this.playerTurnHandler = playerTurnHandler;
        this.messageHandler = new MessageHandler(playerTurnHandler);
    }

    public boolean wrongAnswer() {
        messageHandler.incorrectAnswerMessage();
        getCurrentPlayer().setReceivedPenalty(true);
        playerTurnHandler.setNextPlayerTurn();
        return false;
    }

    public boolean wasCorrectlyAnswered() {
        if (getCurrentPlayer().hasReceivedPenalty()) {
            if (getCurrentPlayer().isGettingOutOfPenaltyBox()) {
                return correctAnswer();
            } else {
                playerTurnHandler.setNextPlayerTurn();
                return false;
            }
        } else {
            return correctAnswer();
        }
    }

    private boolean correctAnswer() {
        getCurrentPlayer().addCoins(1);
        messageHandler.printCurrentPlayerStatus();
        boolean winner = didPlayerWin();
        playerTurnHandler.setNextPlayerTurn();
        return winner;
    }

    private boolean didPlayerWin() {
        return getCurrentPlayer().getCoins() == MAX_COINS_AMOUNT;
    }

    private Player getCurrentPlayer(){
        return playerTurnHandler.getCurrentPlayer();
    }
}
