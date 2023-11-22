package com.example.msassignment.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "START_EVALUATION")

public class StartEvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "START_EVALUATION_ID")
    private Long startEvaluationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNMENT_ID", nullable = false, referencedColumnName = "ASSIGNMENT_ID")
    private AssignmentEntity assignmentId;

    @Column(name = "KEYCLOAK_ID", nullable = false, length = 100)
    private String keycloakId;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "COMPLETED", nullable = false)
    private boolean completed;

    // getters y setteres

    public StartEvaluationEntity() {
    }

    public StartEvaluationEntity(Long startEvaluationId, AssignmentEntity assignmentId, String keycloakId, Date startDate, boolean completed) {
        this.startEvaluationId = startEvaluationId;
        this.assignmentId = assignmentId;
        this.keycloakId = keycloakId;
        this.startDate = startDate;
        this.completed = completed;
    }

    public Long getStartEvaluationId() {
        return startEvaluationId;
    }

    public void setStartEvaluationId(Long startEvaluationId) {
        this.startEvaluationId = startEvaluationId;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
