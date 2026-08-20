package io.github.jesseYeh0319.ticketing.catalog.repository;

import io.github.jesseYeh0319.ticketing.catalog.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}