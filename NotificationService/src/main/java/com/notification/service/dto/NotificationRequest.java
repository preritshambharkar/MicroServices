package com.notification.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NotificationRequest(
        @NotBlank(message = "userId is required")
        String userId,
        @NotBlank(message = "recipient is required")
        @Email(message = "recipient must be a valid email")
        String recipient,
        @NotBlank(message = "subject is required")
        String subject,
        @NotBlank(message = "message is required")
        String message,
        String channel
) {
}
