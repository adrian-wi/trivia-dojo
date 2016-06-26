package com.adaptionsoft.games.trivia.game;

import com.adaptionsoft.games.trivia.Player;
import com.adaptionsoft.games.trivia.QuestionType;

public class MessageHandler {

    private PlayerTurnHandler playerTurnHandler;

    public MessageHandler(PlayerTurnHandler playerTurnHandler) {
        this.playerTurnHandler = playerTurnHandler;
    }

    public void incorrectAnswerMessage() {
        System.out.println("Question was incorrectly answered");
        System.out.println(getCurrentPlayer().getName() + " was sent to the penalty box");
    }


    public void printCurrentPlayerStatus() {
        System.out.println("Answer was correct!!!!");
        System.out.println(getCurrentPlayer().getName()
                + " now has "
                + getCurrentPlayer().getCoins()
                + " Gold Coins.");
    }

    public void printCurrentPlayerRollNumber(int roll) {
        System.out.println(getCurrentPlayer().getName() + " is the current player");
        System.out.println("They have rolled a " + roll);
    }

    public void printCurrentPlayerLocationAndCategoryStatus(QuestionType questionType) {
        System.out.println(getCurrentPlayer().getName()
                + "'s new location is "
                + getCurrentPlayer().getPlayerPosition());
        System.out.println("The category is " + questionType.getPrintableName());
    }

    public void playerAdditionMessage(Player player) {
        System.out.println(player.getName() + " was added");
        System.out.println("They are player number " + playerTurnHandler.getPlayersAmount());
    }

    public void penaltyBoxMessage(boolean condition) {
        String s = condition ? "" : "not ";
        System.out.println(getCurrentPlayer().getName() + " is " + s + "getting out of the penalty box");
    }

    private Player getCurrentPlayer() {
        return playerTurnHandler.getCurrentPlayer();
    }
}
