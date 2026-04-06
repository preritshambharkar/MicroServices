package com.notification.service.service;

import com.notification.service.dto.NotificationMessage;
import com.notification.service.dto.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Locale;
import java.util.UUID;

@Service
public class NotificationPublisher {

    private static final Logger log = LoggerFactory.getLogger(NotificationPublisher.class);

    private final ObjectProvider<RabbitTemplate> rabbitTemplateProvider;
    private final String exchange;
    private final String routingKey;
    private final boolean rabbitEnabled;

    public NotificationPublisher(
            ObjectProvider<RabbitTemplate> rabbitTemplateProvider,
            @Value("${notification.rabbitmq.exchange}") String exchange,
            @Value("${notification.rabbitmq.routing-key}") String routingKey,
            @Value("${notification.rabbitmq.enabled:true}") boolean rabbitEnabled
    ) {
        this.rabbitTemplateProvider = rabbitTemplateProvider;
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.rabbitEnabled = rabbitEnabled;
    }

    public NotificationMessage publish(NotificationRequest request) {
        String channel = request.channel();
        if (channel == null || channel.isBlank()) {
            channel = "EMAIL";
        } else {
            channel = channel.toUpperCase(Locale.ROOT);
        }

        NotificationMessage message = new NotificationMessage(
                UUID.randomUUID().toString(),
                request.userId(),
                request.recipient(),
                request.subject(),
                request.message(),
                channel,
                Instant.now()
        );

        if (rabbitEnabled) {
            RabbitTemplate rabbitTemplate = rabbitTemplateProvider.getIfAvailable();
            if (rabbitTemplate == null) {
                throw new IllegalStateException("RabbitMQ is enabled but RabbitTemplate bean is not available");
            }
            rabbitTemplate.convertAndSend(exchange, routingKey, message);
            log.info("Published notification id={} recipient={}", message.notificationId(), message.recipient());
        } else {
            log.info(
                    "RabbitMQ disabled, notification handled locally id={} recipient={}",
                    message.notificationId(),
                    message.recipient()
            );
        }
        return message;
    }
}
