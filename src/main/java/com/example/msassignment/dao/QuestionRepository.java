package com.example.msassignment.dao;

import com.example.msassignment.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    @Query(value = "SELECT q FROM QuestionEntity q WHERE q.assignmentId.assignmentId = :assignmentId")
    List<QuestionEntity> findAllByAssignmentId(Long assignmentId);
}
