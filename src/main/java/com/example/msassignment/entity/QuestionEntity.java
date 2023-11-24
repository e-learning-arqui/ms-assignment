package com.example.msassignment.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "QUESTION")

public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID")
    private Long questionId;

    @Column(name = "CONTENT", nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNMENT_ID", nullable = false, referencedColumnName = "ASSIGNMENT_ID")
    private AssignmentEntity assignmentId;

    @Column(name = "SCORE", nullable = false)
    private int score;

    // getters y setters

    public QuestionEntity() {
    }

    public QuestionEntity(Long questionId, String content, AssignmentEntity assignmentId, int score) {
        this.questionId = questionId;
        this.content = content;
        this.assignmentId = assignmentId;
        this.score = score;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public AssignmentEntity getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(AssignmentEntity assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
