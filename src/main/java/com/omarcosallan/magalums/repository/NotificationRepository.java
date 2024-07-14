package com.omarcosallan.magalums.repository;

import com.omarcosallan.magalums.entity.Channel;
import com.omarcosallan.magalums.entity.Notification;
import com.omarcosallan.magalums.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndMomentBefore(List<Status> status, LocalDateTime dateTime);
}
