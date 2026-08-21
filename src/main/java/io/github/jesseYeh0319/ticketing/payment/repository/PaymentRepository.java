package io.github.jesseYeh0319.ticketing.payment.repository;

import io.github.jesseYeh0319.ticketing.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}