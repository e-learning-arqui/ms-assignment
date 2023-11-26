package com.example.msassignment.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class ProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_course_id", nullable = false, referencedColumnName = "course_id")
    private CourseEntity courseId;

    @Column(name = "progress_percent")
    private Double progressPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", nullable = false, referencedColumnName = "user_id")
    private Student actorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false, referencedColumnName = "class_id")
    private ClassEntity classId;

    public ProgressEntity() {
    }

    public ProgressEntity(Long progressId, CourseEntity courseId, Double progressPercent, Student actorId, ClassEntity classId) {
        this.progressId = progressId;
        this.courseId = courseId;
        this.progressPercent = progressPercent;
        this.actorId = actorId;
        this.classId = classId;
    }

    public Long getProgressId() {
        return progressId;
    }

    public void setProgressId(Long progressId) {
        this.progressId = progressId;
    }

    public CourseEntity getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseEntity courseId) {
        this.courseId = courseId;
    }

    public Double getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Double progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Student getActorId() {
        return actorId;
    }

    public void setActorId(Student actorId) {
        this.actorId = actorId;
    }

    public ClassEntity getClassId() {
        return classId;
    }

    public void setClassId(ClassEntity classId) {
        this.classId = classId;
    }
}
