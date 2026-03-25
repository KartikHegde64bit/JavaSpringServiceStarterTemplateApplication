package com.example.starter.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExampleRequest {

    @NotBlank(message = "userId is required")
    private String userId;

    @NotNull(message = "value is required")
    private Integer value;

    public ExampleRequest() {
    }

    public ExampleRequest(String userId, Integer value) {
        this.userId = userId;
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
