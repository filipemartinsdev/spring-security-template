package com.spring.app.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterApiUserRequest(
   @NotEmpty(message = "Login is required") String login,
   @NotEmpty(message = "Password is required") String password
) {}
