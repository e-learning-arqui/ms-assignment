package com.example.msassignment.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "class")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false, referencedColumnName = "section_id")
    private SectionEntity sectionId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    public ClassEntity() {
    }

    public ClassEntity(Long classId, SectionEntity sectionId, String title, String description, Integer duration, Date startDate) {
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

    public SectionEntity getSectionId() {
        return sectionId;
    }

    public void setSectionId(SectionEntity sectionId) {
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
