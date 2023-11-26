package com.example.msassignment.dao;

import com.example.msassignment.entity.ProgressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProgressRepository extends JpaRepository<ProgressEntity, Long> {

    @Query(value = "SELECT p FROM ProgressEntity p WHERE p.courseId.courseId = :courseId AND p.actorId.keycloakId = :kcId")
    ProgressEntity findByCourseIdAndKcId(@Param("courseId") Long courseId, @Param("kcId") String kcId);

    @Query(value = "SELECT COUNT(p) > 0 FROM ProgressEntity p WHERE p.courseId.courseId = :courseId AND p.actorId.keycloakId = :kcId AND p.classId.classId = :classId")
    Boolean existsByCourseIdAndKcIdAndClassId(Long courseId, String kcId, Long classId);


    @Query(value = "SELECT COUNT(p) FROM ProgressEntity p WHERE p.courseId.courseId = :courseId AND p.actorId.keycloakId = :actorId")
    Integer classesViewedByKcId(Long courseId, String actorId);

}
