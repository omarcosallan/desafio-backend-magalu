package com.omarcosallan.magalums.controller;

import com.omarcosallan.magalums.dto.ScheduleNotificationDTO;
import com.omarcosallan.magalums.entity.Notification;
import com.omarcosallan.magalums.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDTO dto) {
        notificationService.scheduleNotification(dto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotifications(@PathVariable Long notificationId) {
        Optional<Notification> notification = notificationService.findById(notificationId);

        if (notification.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(notification.get());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotifications(@PathVariable Long notificationId) {
        notificationService.cancelNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
