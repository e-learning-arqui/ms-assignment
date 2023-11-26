package com.example.msassignment.dto;

public class ScoreDto {
    private Integer score;
    private Integer maxScore;

    public ScoreDto() {
    }

    public ScoreDto(Integer score, Integer maxScore) {
        this.score = score;
        this.maxScore = maxScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

}
