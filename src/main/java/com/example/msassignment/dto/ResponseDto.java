package com.example.msassignment.dto;

public class ResponseDto<T> {
    private String code;
    private T response;
    private String errorMessage;

    public ResponseDto() {}

    public ResponseDto(String code, T response, String errorMessage) {
        this.code = code;
        this.response = response;
        this.errorMessage = errorMessage;
    }

    //getters

    public String getCode() {
        return code;
    }

    public T getResponse() {
        return response;
    }

    public String getErrormessage() {
        return errorMessage;
    }

    //setters

    public void setCode(String code) {
        this.code = code;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}