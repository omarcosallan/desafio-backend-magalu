package com.omarcosallan.magalums.repository;

import com.omarcosallan.magalums.entity.Channel;
import com.omarcosallan.magalums.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
