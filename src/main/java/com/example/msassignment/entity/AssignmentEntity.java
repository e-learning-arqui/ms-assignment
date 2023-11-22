package com.example.msassignment.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ASSIGNMENT")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSIGNMENT_ID")
    private Long assignmentId;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNMENT_TYPE_ID", nullable = false, referencedColumnName = "ASSIGNMENT_TYPE_ID")
    private AssignmentTypeEntity assignmentTypeId;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION_ID", nullable = false, referencedColumnName = "SECTION_ID")
    private SectionEntity sectionId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID", nullable = false, referencedColumnName = "COURSE_ID")
    private CourseEntity courseId;

    // getters y setteres
    public AssignmentEntity() {
    }

    public AssignmentEntity(Long assignmentId, String title, AssignmentTypeEntity assignmentTypeId, Date startDate, SectionEntity sectionId, CourseEntity courseId) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.assignmentTypeId = assignmentTypeId;
        this.startDate = startDate;
        this.sectionId = sectionId;
        this.courseId = courseId;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public AssignmentTypeEntity getAssignmentTypeId() {
        return assignmentTypeId;
    }

    public void setAssignmentTypeId(AssignmentTypeEntity assignmentTypeId) {
        this.assignmentTypeId = assignmentTypeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public SectionEntity getSectionId() {
        return sectionId;
    }

    public void setSectionId(SectionEntity sectionId) {
        this.sectionId = sectionId;
    }

    public CourseEntity getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseEntity courseId) {
        this.courseId = courseId;
    }



}
