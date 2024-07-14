package com.omarcosallan.magalums.service;

import com.omarcosallan.magalums.dto.ScheduleNotificationDTO;
import com.omarcosallan.magalums.entity.Notification;
import com.omarcosallan.magalums.entity.Status;
import com.omarcosallan.magalums.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDTO dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return notificationRepository.findById(notificationId);
    }

    public void cancelNotification(Long notificationId) {
        Optional<Notification> notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(Status.Values.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }

    public void checkAndSend(LocalDateTime dateTime) {
        List<Notification> notifications = notificationRepository.findByStatusInAndMomentBefore(List.of(
                Status.Values.PENDING.toStatus(),
                Status.Values.ERROR.toStatus()
        ), dateTime);

        notifications.forEach(sendNotification());
    }

    private Consumer<Notification> sendNotification() {
        return n -> {
            // TODO - Realizar o envio

            n.setStatus(Status.Values.SUCCESS.toStatus());
            notificationRepository.save(n);
        };
    }
}
