package com.adaptionsoft.games.trivia;

import java.util.LinkedList;

public class Questions {

    private LinkedList<String> questions;

    public Questions() {
        this.questions = new LinkedList<>();
    }

    public void add(String question) {
        questions.add(question);
    }

    public String removeFirstQuestion() {
        return questions.removeFirst();
    }
}
