package io.github.jesseYeh0319.ticketing.catalog.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "event_session")
public class EventSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "starts_at", nullable = false)
    private Instant startsAt;

    @Column(name = "sale_starts_at", nullable = false)
    private Instant saleStartsAt;

    @Column(name = "sale_ends_at", nullable = false)
    private Instant saleEndsAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private SessionStatus status;

    protected EventSession() {}

    public EventSession(Long eventId, Instant startsAt, Instant saleStartsAt, Instant saleEndsAt) {
        this.eventId = eventId;
        this.startsAt = startsAt;
        this.saleStartsAt = saleStartsAt;
        this.saleEndsAt = saleEndsAt;
        this.status = SessionStatus.DRAFT;
    }

    public Long getId() { return id; }
    public Long getEventId() { return eventId; }
    public Instant getStartsAt() { return startsAt; }
    public Instant getSaleStartsAt() { return saleStartsAt; }
    public Instant getSaleEndsAt() { return saleEndsAt; }
    public SessionStatus getStatus() { return status; }
}