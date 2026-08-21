package io.github.jesseYeh0319.ticketing.catalog.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "zone_inventory")
public class ZoneInventory {

    @Id
    @Column(name = "zone_id")
    private Long zoneId;

    @Column(nullable = false)
    private Integer available;

    @Column(nullable = false)
    private Integer locked;

    @Column(nullable = false)
    private Integer sold;

    @Version
    @Column(nullable = false)
    private Long version;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected ZoneInventory() {}

    public ZoneInventory(Long zoneId, Integer available) {
        this.zoneId = zoneId;
        this.available = available;
        this.locked = 0;
        this.sold = 0;
        this.version = 0L;
        this.updatedAt = Instant.now();
    }

    public Long getZoneId() { return zoneId; }
    public Integer getAvailable() { return available; }
    public Integer getLocked() { return locked; }
    public Integer getSold() { return sold; }
    public Long getVersion() { return version; }
    public Instant getUpdatedAt() { return updatedAt; }
}