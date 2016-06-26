package com.adaptionsoft.games.trivia;

public enum QuestionType {
    SCIENCE("Science"), POP("Pop"), ROCK("Rock"), SPORTS("Sports");

    private String printableName;

    QuestionType(String name) {
        this.printableName = name;
    }

    public String getPrintableName() {
        return printableName;
    }
}
