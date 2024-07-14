package com.omarcosallan.magalums.dto;

import com.omarcosallan.magalums.entity.Channel;
import com.omarcosallan.magalums.entity.Notification;
import com.omarcosallan.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDTO(LocalDateTime moment,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {

    public Notification toNotification() {
        return new Notification(
                moment,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus());
    }
}
