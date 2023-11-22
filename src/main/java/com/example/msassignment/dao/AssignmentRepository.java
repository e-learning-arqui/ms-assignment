package com.example.msassignment.dao;

import com.example.msassignment.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
    @Query(value = "SELECT a FROM AssignmentEntity a WHERE a.courseId.courseId = :courseId")
    List<AssignmentEntity> findAllByCourseId(@Param("courseId") Long courseId);


}
