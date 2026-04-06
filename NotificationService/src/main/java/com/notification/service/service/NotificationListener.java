package com.notification.service.service;

import com.notification.service.dto.NotificationMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(
        name = "notification.rabbitmq.enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class NotificationListener {

    private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);

    @RabbitListener(queues = "${notification.rabbitmq.queue}")
    public void consumeNotification(NotificationMessage message) {
        log.info(
                "Received notification id={} userId={} recipient={} subject={}",
                message.notificationId(),
                message.userId(),
                message.recipient(),
                message.subject()
        );
    }
}
