package com.example.msassignment.dao;

import com.example.msassignment.entity.StudentAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswerEntity, Long> {
    @Query("SELECT SUM(qe.score) FROM StudentAnswerEntity sae " +
            "JOIN sae.optionId qo " +
            "JOIN qo.questionId qe " +
            "WHERE sae.keycloakId = :keycloakId " +
            "AND sae.assignmentId.assignmentId = :assignmentId " +
            "AND qo.isCorrect = TRUE")
    Integer findTotalScoreByKeycloakIdAndAssignmentId(String keycloakId, Long assignmentId);


    @Query("SELECT SUM(q.score) FROM QuestionEntity q WHERE q.assignmentId.assignmentId = :assignmentId")
    int findMaxScoreByAssignmentId(Long assignmentId);
    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM StudentAnswerEntity s WHERE s.keycloakId = :keycloakId AND s.assignmentId.assignmentId = :assignmentId")
    boolean existsByKeycloakIdAndAssignmentId(String keycloakId, Long assignmentId);
}
