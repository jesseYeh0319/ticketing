package io.github.jesseYeh0319.ticketing.catalog.repository;

import io.github.jesseYeh0319.ticketing.catalog.domain.ZoneInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneInventoryRepository extends JpaRepository<ZoneInventory, Long> {
}
