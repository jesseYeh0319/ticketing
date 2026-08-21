package io.github.jesseYeh0319.ticketing.order.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Column(name = "zone_id", nullable = false)
    private Long zoneId;

    @Column(name = "seat_id")
    private Long seatId;

    @Column(name = "price_cents", nullable = false)
    private Long priceCents;

    protected OrderItem() {}

    public OrderItem(UUID orderId, Long zoneId, Long seatId, Long priceCents) {
        this.orderId = orderId;
        this.zoneId = zoneId;
        this.seatId = seatId;
        this.priceCents = priceCents;
    }

    public Long getId() { return id; }
    public UUID getOrderId() { return orderId; }
    public Long getZoneId() { return zoneId; }
    public Long getSeatId() { return seatId; }
    public Long getPriceCents() { return priceCents; }
}