package com.example.msassignment.dto;

public class StudentAnswerDto {
    private Long id;
    private int optionId;
    private String keycloakId;

    public StudentAnswerDto() {}

    public StudentAnswerDto(Long id, int optionId, String keycloakId) {
        this.id = id;
        this.optionId = optionId;
        this.keycloakId = keycloakId;
    }

    // getters setters y to string

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public int getOptionId() {return optionId;}

    public void setOptionId(int optionId) {this.optionId = optionId;}

    public String getKeycloakId() {return keycloakId;}

    public void setKeycloakId(String keycloakId) {this.keycloakId = keycloakId;}


}
