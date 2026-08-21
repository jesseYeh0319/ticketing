package io.github.jesseYeh0319.ticketing.catalog.repository;

import io.github.jesseYeh0319.ticketing.catalog.domain.EventSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventSessionRepository extends JpaRepository<EventSession, Long> {
}
