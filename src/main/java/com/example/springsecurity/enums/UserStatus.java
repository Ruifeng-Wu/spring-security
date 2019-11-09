package com.example.springsecurity.enums;

public enum UserStatus {
    ACTIVE("can use"),
    UNACTIVE("cant use");

    private String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
