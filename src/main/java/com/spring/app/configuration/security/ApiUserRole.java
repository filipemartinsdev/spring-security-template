package com.spring.app.configuration.security;

public enum ApiUserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    ApiUserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }
}
