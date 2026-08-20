package io.github.jesseYeh0319.ticketing.catalog.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String venue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private EventStatus status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    protected Event() {}          // JPA 要求的無參建構子,設 protected 防止外部誤用

    public Event(String name, String venue) {
        this.name = name;
        this.venue = venue;
        this.status = EventStatus.DRAFT;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getVenue() { return venue; }
    public EventStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
}