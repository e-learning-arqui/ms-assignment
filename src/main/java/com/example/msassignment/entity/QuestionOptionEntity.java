package com.example.msassignment.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "QUESTION_OPTION")
public class QuestionOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID")
    private Long optionId;

    @Column(name = "OPTION", nullable = false)
    private String option;

    @Column(name = "IS_CORRECT", nullable = false)
    private boolean isCorrect;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID", nullable = false, referencedColumnName = "QUESTION_ID")
    private QuestionEntity questionId;

    public QuestionOptionEntity() {
    }

    public QuestionOptionEntity(Long optionId, String option, boolean isCorrect, QuestionEntity questionId) {
        this.optionId = optionId;
        this.option = option;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionEntity getQuestionId() {
        return questionId;
    }

    public void setQuestionId(QuestionEntity questionId) {
        this.questionId = questionId;
    }


}
