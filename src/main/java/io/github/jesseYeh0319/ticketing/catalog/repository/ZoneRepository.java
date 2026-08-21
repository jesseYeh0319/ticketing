package io.github.jesseYeh0319.ticketing.catalog.repository;

import io.github.jesseYeh0319.ticketing.catalog.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
