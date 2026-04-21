package com.user.service.rabbitmq.service;

import com.user.service.entities.User;
import com.user.service.rabbitmq.dto.NotificationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserNotificationPublisher {

    private static final Logger log = LoggerFactory.getLogger(UserNotificationPublisher.class);

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public UserNotificationPublisher(
            RabbitTemplate rabbitTemplate,
            @Value("${notification.rabbitmq.exchange}") String exchange,
            @Value("${notification.rabbitmq.routing-key}") String routingKey
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public NotificationEvent publishUserCreatedEvent(User user) {
        NotificationEvent event = new NotificationEvent(
                UUID.randomUUID().toString(),
                String.valueOf(user.getUserId()),
                user.getEmail(),
                "Welcome to Auction Platform",
                "Hello " + user.getFirst_name() + ", your account was created successfully.",
                "EMAIL",
                Instant.now()
        );
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
        log.info("Published user-created event for userId={} email={}", event.userId(), event.recipient());
        return event;
    }

    public NotificationEvent publishExampleEvent() {
        NotificationEvent event = new NotificationEvent(
                UUID.randomUUID().toString(),
                "demo-user-1001",
                "demo.user@example.com",
                "Example Event from USER-SERVICE",
                "This notification is triggered from USER-SERVICE.",
                "EMAIL",
                Instant.now()
        );
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
        log.info("Published demo user-service event id={}", event.notificationId());
        return event;
    }
}
