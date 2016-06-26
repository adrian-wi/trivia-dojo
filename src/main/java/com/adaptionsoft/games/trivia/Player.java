package com.adaptionsoft.games.trivia;

public class Player {

    private static final int MAX_ALLOWED_POSITION = 11;
    private static final int BOARD_POSITION_AMOUNT = 12;
    private boolean receivedPenalty;
    private boolean isGettingOutOfPenaltyBox;
    private int playerPosition;
    private int coins;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition += playerPosition;
        if(this.playerPosition > MAX_ALLOWED_POSITION)
            this.playerPosition += - BOARD_POSITION_AMOUNT;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setReceivedPenalty(boolean receivedPenalty) {
        this.receivedPenalty = receivedPenalty;
    }

    public boolean hasReceivedPenalty() {
        return receivedPenalty;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    public void setGettingOutOfPenaltyBox(boolean gettingOutOfPenaltyBox) {
        isGettingOutOfPenaltyBox = gettingOutOfPenaltyBox;
    }
}
