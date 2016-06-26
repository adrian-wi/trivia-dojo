package com.adaptionsoft.games.trivia.game;

import com.adaptionsoft.games.trivia.Player;

public class PositionShiftingHandler {

    private Player currentPlayer;
    private MessageHandler messageHandler;

    public PositionShiftingHandler(Player currentPlayer, PlayerTurnHandler playerTurnHandler) {
        this.currentPlayer = currentPlayer;
        this.messageHandler = new MessageHandler(playerTurnHandler);
    }

    public boolean isShiftable(int roll) {
        return currentPlayer.hasReceivedPenalty() ? handlePenaltyBox(roll) : true;
    }

    private boolean handlePenaltyBox(int roll) {
        boolean condition = roll % 2 != 0;
        messageHandler.penaltyBoxMessage(condition);
        currentPlayer.setGettingOutOfPenaltyBox(condition);
        return condition;
    }
}
