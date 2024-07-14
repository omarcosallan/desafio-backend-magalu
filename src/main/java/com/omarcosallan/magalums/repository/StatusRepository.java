package com.omarcosallan.magalums.repository;

import com.omarcosallan.magalums.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
