package com.notification.service.dto;

import java.time.Instant;

public record NotificationMessage(
        String notificationId,
        String userId,
        String recipient,
        String subject,
        String message,
        String channel,
        Instant createdAt
) {
}
