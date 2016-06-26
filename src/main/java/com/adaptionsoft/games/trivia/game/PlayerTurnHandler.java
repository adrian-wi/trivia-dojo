package com.adaptionsoft.games.trivia.game;

import com.adaptionsoft.games.trivia.Player;

import java.util.List;

public class PlayerTurnHandler {

    private List<Player> players;
    private int currentPlayerIndex;

    public PlayerTurnHandler(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void setNextPlayerTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) {
            currentPlayerIndex = 0;
        }
    }

    public int getPlayersAmount() {
        return players.size();
    }
}
