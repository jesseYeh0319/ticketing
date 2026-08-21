package io.github.jesseYeh0319.ticketing.catalog.repository;

import io.github.jesseYeh0319.ticketing.catalog.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
