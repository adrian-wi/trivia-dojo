package com.adaptionsoft.games.trivia.game;

import com.adaptionsoft.games.trivia.BoardQuestionMapper;
import com.adaptionsoft.games.trivia.Player;
import com.adaptionsoft.games.trivia.QuestionGenerator;
import com.adaptionsoft.games.trivia.QuestionType;

import java.util.ArrayList;

public class Game {
    private final QuestionGenerator questionGenerator;
    private final BoardQuestionMapper boardQuestionMapper;
    private PlayerTurnHandler playerTurnHandler;
    private AnswerResolver answerResolver;
    private ArrayList<Player> players = new ArrayList<>();
    private MessageHandler messageHandler;

    public Game() {
        this.questionGenerator = new QuestionGenerator();
        this.boardQuestionMapper = new BoardQuestionMapper();
        this.playerTurnHandler = new PlayerTurnHandler(players);
        this.answerResolver = new AnswerResolver(playerTurnHandler);
        this.messageHandler = new MessageHandler(playerTurnHandler);
    }

    public boolean wasCorrectlyAnswered() {
        return answerResolver.wasCorrectlyAnswered();
    }

    public boolean wrongAnswer() {
        return answerResolver.wrongAnswer();
    }

    public boolean add(Player player) {
        players.add(player);
        messageHandler.playerAdditionMessage(player);
        return true;
    }

    public void roll(int roll) {
        messageHandler.printCurrentPlayerRollNumber(roll);

        boolean shiftable = new PositionShiftingHandler(getCurrentPlayer(), playerTurnHandler).isShiftable(roll);
        if (shiftable) {
            setNewPosition(roll);
            askQuestion();
        }

    }

    private void setNewPosition(int roll) {
        getCurrentPlayer().setPlayerPosition(roll);
        messageHandler.printCurrentPlayerLocationAndCategoryStatus(currentCategory());
    }

    private void askQuestion() {
        System.out.println(questionGenerator.getQuestion(currentCategory()));
    }

    private QuestionType currentCategory() {
        return boardQuestionMapper.getQuestionTypeForPosition(getCurrentPlayer().getPlayerPosition());
    }

    private Player getCurrentPlayer() {
        return playerTurnHandler.getCurrentPlayer();
    }
}
