
package com.example.msassignment.dto;
public class ProgressDto {

    private Long id;
    private Long courseId;
    private Double progressPercent;
    private Long actorId;

    public ProgressDto() {
    }

    public ProgressDto(Long progressId, Long courseId, Double progressPercent, Long actorId) {
        this.id = progressId;
        this.courseId = courseId;
        this.progressPercent = progressPercent;
        this.actorId = actorId;
    }

    public Long getId() {
        return id;
    }

    public void setProgressId(Long progressId) {
        this.id = progressId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Double getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Double progressPercent) {
        this.progressPercent = progressPercent;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }
}

