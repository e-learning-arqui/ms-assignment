package com.example.msassignment.dto;

public class QuestionOptionDto {
    private Long id;
    private String option;
    private boolean isCorrect;

    private int questionId;

    public QuestionOptionDto() {}

    public QuestionOptionDto(Long id, String option, boolean isCorrect, int questionId) {
        this.id = id;
        this.option = option;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    // getters setters y to string

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getOption() {return option;}

    public void setOption(String option) {this.option = option;}

    public boolean isCorrect() {return isCorrect;}

    public void setCorrect(boolean correct) {isCorrect = correct;}

    public int getQuestionId() {return questionId;}

    public void setQuestionId(int questionId) {this.questionId = questionId;}


}
