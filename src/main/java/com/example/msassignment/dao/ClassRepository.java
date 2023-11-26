package com.example.msassignment.dao;

import com.example.msassignment.entity.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

    @Query("SELECT c FROM ClassEntity c WHERE c.sectionId.courseId.courseId = :courseId")
    Page<ClassEntity> getClassesByCourseId(@Param("courseId") Long courseId, Pageable pageable);

    @Query("SELECT c FROM ClassEntity c WHERE c.sectionId.sectionId = :sectionId")
    List<ClassEntity> getClassesBySectionId(@Param("sectionId") Long sectionId);

//    @Query("SELECT c FROM ClassEntity c WHERE c.sectionId.courseId.courseId = :courseId")
//    List<ClassEntity> classesByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT c FROM ClassEntity c WHERE c.sectionId.courseId.courseId = :courseId")
    ClassEntity findByCourseId(Long courseId);
}
