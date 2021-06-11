package com.example.quizapp;

public class AnswerClass {

    private int optionA,optionB,optionC,optionD,questionID,answerID;

    public AnswerClass(int questionID,int optionA, int optionB, int optionC, int optionD, int answerID) {
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.questionID = questionID;
        this.answerID = answerID;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionID() {
        return questionID;
    }

    public int getAnswerID() {
        return answerID;
    }
}
