package com.example.msassignment.dao;

import com.example.msassignment.entity.SectionEntity;
import com.example.msassignment.entity.StartEvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StartEvaluationRepository extends JpaRepository<StartEvaluationEntity, Long> {
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM StartEvaluationEntity s WHERE s.keycloakId = :keycloakId AND s.assignmentId.assignmentId = :assignmentId")
    boolean hasStartedEvaluation(String keycloakId, Long assignmentId);
}

