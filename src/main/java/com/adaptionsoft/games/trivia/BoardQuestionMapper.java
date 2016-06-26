package com.adaptionsoft.games.trivia;

import java.util.HashMap;
import java.util.Map;

public class BoardQuestionMapper {

    private Map<Integer, QuestionType> questionTypeMap = new HashMap<>();
    {
        questionTypeMap.put(0, QuestionType.POP);
        questionTypeMap.put(1, QuestionType.SCIENCE);
        questionTypeMap.put(2, QuestionType.SPORTS);
        questionTypeMap.put(3, QuestionType.ROCK);
    }

    public QuestionType getQuestionTypeForPosition(int postion) {
        return questionTypeMap.get(postion%4);
    }
}
