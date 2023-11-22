package com.example.msassignment.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "ASSIGNMENT_TYPE")
public class AssignmentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSIGNMENT_TYPE_ID")
    private Long assignmentTypeId;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;

    public AssignmentTypeEntity() {}

    public AssignmentTypeEntity(String description) {
        this.description = description;
    }

    // Getters and setters

    public Long getAssignmentTypeId() {
        return assignmentTypeId;
    }

    public void setAssignmentTypeId(Long assignmentTypeId) {
        this.assignmentTypeId = assignmentTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
