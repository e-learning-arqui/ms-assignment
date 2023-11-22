package com.example.msassignment.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "COURSE")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "TITLE", nullable = false, length = 200)
    private String title;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "DESCRIPTION", nullable = false, length = 1000)
    private String description;

    @Column(name = "LAST_UPDATE", nullable = false)
    private Date lastUpdate;

    @Column(name = "VERSION", nullable = false)
    private int version;

    @Column(name = "DURATION", nullable = false)
    private int duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LANGUAGE_ID", nullable = false, referencedColumnName = "LANGUAGE_ID")
    private LanguageEntity languageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEVEL_ID", nullable = false, referencedColumnName = "LEVEL_ID")
    private LevelEntity levelId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUB_CATEGORY_ID", nullable = false, referencedColumnName = "SUB_CATEGORY_ID")
    private SubCategoryEntity subCategoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFESSOR_ID", nullable = false, referencedColumnName = "PROFESSOR_ID")
    private ProfessorEntity professorId;
    public CourseEntity() {}

    public CourseEntity(String title, Date startDate, boolean status, String description, Date lastUpdate,
                        int version, int duration, LanguageEntity languageId,
                        LevelEntity levelId, SubCategoryEntity subCategoryId, ProfessorEntity professorId ) {
        this.title = title;
        this.startDate = startDate;
        this.status = status;
        this.description = description;
        this.lastUpdate = lastUpdate;
        this.version = version;
        this.duration = duration;
        this.languageId = languageId;
        this.levelId = levelId;
        this.subCategoryId = subCategoryId;
        this.professorId = professorId;

    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ProfessorEntity getProfessorId() {
        return professorId;
    }

    public void setProfessorId(ProfessorEntity professorId) {
        this.professorId = professorId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LanguageEntity getLanguageId() {
        return languageId;
    }

    public void setLanguageId(LanguageEntity languageId) {
        this.languageId = languageId;
    }

    public LevelEntity getLevelId() {
        return levelId;
    }

    public void setLevelId(LevelEntity levelId) {
        this.levelId = levelId;
    }

    public SubCategoryEntity getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(SubCategoryEntity subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", version=" + version +
                ", duration=" + duration +
                ", languageId=" + languageId +
                ", levelId=" + levelId +
                ", subCategoryId=" + subCategoryId +
                ", professorId=" + professorId +
                '}';
    }
}




