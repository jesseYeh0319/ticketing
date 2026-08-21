package io.github.jesseYeh0319.ticketing.catalog.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id", nullable = false)
    private Long sessionId;

    @Column(nullable = false, length = 64)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "seating_type", nullable = false, length = 16)
    private SeatingType seatingType;

    @Column(name = "price_cents", nullable = false)
    private Long priceCents;

    @Column(nullable = false)
    private Integer capacity;

    protected Zone() {}

    public Zone(Long sessionId, String name, SeatingType seatingType, Long priceCents, Integer capacity) {
        this.sessionId = sessionId;
        this.name = name;
        this.seatingType = seatingType;
        this.priceCents = priceCents;
        this.capacity = capacity;
    }

    public Long getId() { return id; }
    public Long getSessionId() { return sessionId; }
    public String getName() { return name; }
    public SeatingType getSeatingType() { return seatingType; }
    public Long getPriceCents() { return priceCents; }
    public Integer getCapacity() { return capacity; }
}