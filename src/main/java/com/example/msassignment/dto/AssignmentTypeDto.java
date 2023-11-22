package com.example.msassignment.dto;

public class AssignmentTypeDto {
    private Long id;
    private String description;

    public AssignmentTypeDto() {}

    public AssignmentTypeDto(Long id, String name, String description) {
        this.id = id;
        this.description = description;
    }

    // getters setters y to string
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    @Override
    public String toString() {
        return "AssignmentType{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
