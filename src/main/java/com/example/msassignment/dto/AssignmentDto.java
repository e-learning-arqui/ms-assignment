package com.example.msassignment.dto;

import java.util.Date;
import java.util.List;

public class AssignmentDto {
    private Long id;
    private String title;
    private Long assignmentTypeId;
    private Date startDate;
    private Long sectionId;
    private Long courseId;

    private List<QuestionDto> questions;

    public AssignmentDto() {}

    public AssignmentDto(Long id, String title, Long assignmentTypeId, Date startDate, Long sectionId, Long courseId) {
        this.id = id;
        this.title = title;
        this.assignmentTypeId = assignmentTypeId;
        this.startDate = startDate;
        this.sectionId = sectionId;
        this.courseId = courseId;
    }

    // getters setters y to string
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public Long getAssignmentTypeId() {return assignmentTypeId;}

    public void setAssignmentTypeId(Long assignmentTypeId) {this.assignmentTypeId = assignmentTypeId;}

    public Date getStartDate() {return startDate;}

    public void setStartDate(Date startDate) {this.startDate = startDate;}

    public Long getSectionId() {return sectionId;}

    public void setSectionId(Long sectionId) {this.sectionId = sectionId;}

    public Long getCourseId() {return courseId;}

    public void setCourseId(Long courseId) {this.courseId = courseId;}

    public List<QuestionDto> getQuestions() {return questions;}

    public void setQuestions(List<QuestionDto> questions) {this.questions = questions;}



}

