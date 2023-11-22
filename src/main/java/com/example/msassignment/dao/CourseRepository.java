package com.example.msassignment.dao;

import com.example.msassignment.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>, JpaSpecificationExecutor<CourseEntity> {
    @Query(value = "SELECT * FROM course WHERE status = true", nativeQuery = true)
    //@Query(value = "SELECT c FROM CourseEntity c WHERE c.status = true")
    Page <CourseEntity> findAllCourses(Pageable pageable);



    CourseEntity findByCourseId(Long courseId);

    @Query(value = "SELECT c FROM CourseEntity c WHERE c.professorId.professorId = :professorId")
    Page<CourseEntity> findByProfessorId(@Param("professorId") Long professorId, Pageable pageable);
}

