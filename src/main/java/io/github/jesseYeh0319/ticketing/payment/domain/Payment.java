package io.github.jesseYeh0319.ticketing.payment.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private PaymentStatus status;

    @Column(name = "amount_cents", nullable = false)
    private Long amountCents;

    @Column(name = "external_ref", length = 128)
    private String externalRef;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "paid_at")
    private Instant paidAt;

    protected Payment() {}

    public Payment(UUID orderId, Long amountCents) {
        this.orderId = orderId;
        this.status = PaymentStatus.PENDING;
        this.amountCents = amountCents;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public UUID getOrderId() { return orderId; }
    public PaymentStatus getStatus() { return status; }
    public Long getAmountCents() { return amountCents; }
    public String getExternalRef() { return externalRef; }
    public Instant getCreatedAt() { return createdAt; }
    public Instant getPaidAt() { return paidAt; }
}