package com.example.msassignment.dao;

import com.example.msassignment.entity.QuestionOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionOptionRepository extends JpaRepository<QuestionOptionEntity, Long> {
    @Query(value = "SELECT q FROM QuestionOptionEntity q WHERE q.questionId.questionId = :questionId")
    List<QuestionOptionEntity> findAllByQuestionId(Long questionId);
}
