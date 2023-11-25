package com.example.msassignment.dto;

public class ProgressMessageDto {

    private Long id;

    private String userKeyCloakId;

    private Long courseId;

    private Long classId;

    public ProgressMessageDto() {
    }

    public ProgressMessageDto(Long id, String userKeyCloakId, Long courseId, Long classId) {
        this.id = id;
        this.userKeyCloakId = userKeyCloakId;
        this.courseId = courseId;
        this.classId = classId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserKeyCloakId() {
        return userKeyCloakId;
    }

    public void setUserKeyCloakId(String userKeyCloakId) {
        this.userKeyCloakId = userKeyCloakId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
