package com.adaptionsoft.games.trivia;

import java.util.HashMap;
import java.util.Map;

public class QuestionGenerator {

    private Map<QuestionType,Questions> questionTypes = new HashMap<>();
    {
        questionTypes.put(QuestionType.POP, new Questions() );
        questionTypes.put(QuestionType.SCIENCE, new Questions() );
        questionTypes.put(QuestionType.SPORTS, new Questions() );
        questionTypes.put(QuestionType.ROCK, new Questions() );
    }

    public QuestionGenerator() {

        for (int i = 0; i < 50; i++) {
            questionTypes.get(QuestionType.POP).add("Pop Question " + i);
            questionTypes.get(QuestionType.SCIENCE).add("Science Question " + i);
            questionTypes.get(QuestionType.SPORTS).add("Sports Question " + i);
            questionTypes.get(QuestionType.ROCK).add("Rock Question " + i);
        }
    }

    public String getQuestion(QuestionType type) {
        return questionTypes.get(type).removeFirstQuestion();
    }
}
