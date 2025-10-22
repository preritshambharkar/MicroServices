package com.car.service.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
    private String message;
    private int responseCode;
    private HttpStatus status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ApiResponse(String message, int responseCode, HttpStatus status) {
        this.message = message;
        this.responseCode = responseCode;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", responseCode=" + responseCode +
                ", status=" + status +
                '}';
    }
}
