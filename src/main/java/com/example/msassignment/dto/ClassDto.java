package com.example.msassignment.dto;

import java.util.Date;

public class ClassDto {

    private Long classId;
    private Long sectionId;
    private String title;
    private String description;
    private Integer duration;
    private Date startDate;

    public ClassDto() {
    }

    public ClassDto(Long classId, Long sectionId, String title, String description, Integer duration, Date startDate) {
        this.classId = classId;
        this.sectionId = sectionId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.startDate = startDate;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
