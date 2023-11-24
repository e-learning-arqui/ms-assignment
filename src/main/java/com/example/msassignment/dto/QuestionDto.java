package com.example.msassignment.dto;

import java.util.List;

public class QuestionDto {
    private Long id;
    private String content;
    private Long assignmentId;
    private int score;

    private List<QuestionOptionDto> options;

    public QuestionDto() {}

    public QuestionDto(Long id, String content, Long assignmentId, int score) {
        this.id = id;
        this.content = content;
        this.assignmentId = assignmentId;
        this.score = score;
    }

    // getters setters y to string

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public Long getAssignmentId() {return assignmentId;}

    public void setAssignmentId(Long assignmentId) {this.assignmentId = assignmentId;}

    public int getScore() {return score;}

    public void setScore(int score) {this.score = score;}

    public List<QuestionOptionDto> getOptions() {return options;}

    public void setOptions(List<QuestionOptionDto> options) {this.options = options;}

    // toString
    @Override

    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", assignmentId=" + assignmentId +
                ", score=" + score +
                '}';
    }



}
