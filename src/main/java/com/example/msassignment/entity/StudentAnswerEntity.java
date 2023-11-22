package com.example.msassignment.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "STUDENT_ANSWER")

public class StudentAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTOR_ANSWER_ID")
    private Long actorAnswerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPTION_ID", nullable = false, referencedColumnName = "OPTION_ID")
    private QuestionOptionEntity optionId;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNMENT_ID", nullable = false, referencedColumnName = "ASSIGNMENT_ID")
    private AssignmentEntity assignmentId;

    @Column(name = "KEYCLOAK_ID", nullable = false, length = 100)
    private String keycloakId;

    public StudentAnswerEntity() {
    }

    public StudentAnswerEntity(Long actorAnswerId, QuestionOptionEntity optionId, Date date, AssignmentEntity assignmentId, String keycloakId) {
        this.actorAnswerId = actorAnswerId;
        this.optionId = optionId;
        this.date = date;
        this.assignmentId = assignmentId;
        this.keycloakId = keycloakId;
    }

    public Long getActorAnswerId() {
        return actorAnswerId;
    }

    public void setActorAnswerId(Long actorAnswerId) {
        this.actorAnswerId = actorAnswerId;
    }

    public QuestionOptionEntity getOptionId() {
        return optionId;
    }

    public void setOptionId(QuestionOptionEntity optionId) {
        this.optionId = optionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AssignmentEntity getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(AssignmentEntity assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
    }


}
