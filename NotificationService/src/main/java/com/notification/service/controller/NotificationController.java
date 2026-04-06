package com.notification.service.controller;

import com.notification.service.dto.NotificationMessage;
import com.notification.service.dto.NotificationRequest;
import com.notification.service.service.NotificationPublisher;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationPublisher notificationPublisher;

    public NotificationController(NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }

    @PostMapping("/publish")
    public ResponseEntity<NotificationMessage> publishNotification(@Valid @RequestBody NotificationRequest request) {
        NotificationMessage publishedMessage = notificationPublisher.publish(request);
        return ResponseEntity.accepted().body(publishedMessage);
    }

    @PostMapping("/example")
    public ResponseEntity<NotificationMessage> publishExampleNotification() {
        NotificationRequest request = new NotificationRequest(
                "demo-user-1001",
                "demo.user@example.com",
                "Bid Update",
                "Your bid is currently the highest.",
                "EMAIL"
        );
        NotificationMessage publishedMessage = notificationPublisher.publish(request);
        return ResponseEntity.accepted().body(publishedMessage);
    }
}
