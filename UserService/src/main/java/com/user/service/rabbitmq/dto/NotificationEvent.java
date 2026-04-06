package com.user.service.rabbitmq.dto;

import java.time.Instant;

public record NotificationEvent(
        String notificationId,
        String userId,
        String recipient,
        String subject,
        String message,
        String channel,
        Instant createdAt
) {
}
