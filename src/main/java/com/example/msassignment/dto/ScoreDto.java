package com.example.msassignment.dto;

public class ScoreDto {
    private int score;
    private int maxScore;

    public ScoreDto() {
    }

    public ScoreDto(int score, int maxScore) {
        this.score = score;
        this.maxScore = maxScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

}
