package io.github.jesseYeh0319.ticketing.order.domain;

public enum OrderStatus {
    CREATED, LOCKED, PENDING_PAYMENT, PAID, ISSUED,
    EXPIRED, CANCELLED, RELEASED, REFUNDED
}