package io.github.jesseYeh0319.ticketing.catalog.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_id", nullable = false)
    private Long zoneId;

    @Column(name = "row_label", nullable = false, length = 8)
    private String rowLabel;

    @Column(name = "seat_no", nullable = false, length = 8)
    private String seatNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private SeatStatus status;

    @Version
    @Column(nullable = false)
    private Long version;

    protected Seat() {}

    public Seat(Long zoneId, String rowLabel, String seatNo) {
        this.zoneId = zoneId;
        this.rowLabel = rowLabel;
        this.seatNo = seatNo;
        this.status = SeatStatus.AVAILABLE;
        this.version = 0L;
    }

    public Long getId() { return id; }
    public Long getZoneId() { return zoneId; }
    public String getRowLabel() { return rowLabel; }
    public String getSeatNo() { return seatNo; }
    public SeatStatus getStatus() { return status; }
    public Long getVersion() { return version; }
}