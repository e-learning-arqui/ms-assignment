package com.example.msassignment.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "LEVEL_COURSE")
public class LevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEVEL_ID")
    private Long levelId;

    @Column(name = "LEVEL_NAME", nullable = false, length = 200)
    private String levelName;

    @Column(name = "DESCRIPTION", nullable = false, length = 200)
    private String description;

    public LevelEntity() {}

    public LevelEntity(String levelName, String description) {
        this.levelName = levelName;
        this.description = description;
    }

    // Getters and Setters

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //setID
    public void setId(Long id) {
        this.levelId = id;
    }
    //getID
    public Long getId() {
        return this.levelId;
    }

    @Override
    public String toString() {
        return "Level{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
