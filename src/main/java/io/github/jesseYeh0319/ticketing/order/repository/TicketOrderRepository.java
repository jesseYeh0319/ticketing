package io.github.jesseYeh0319.ticketing.order.repository;

import io.github.jesseYeh0319.ticketing.order.domain.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, UUID> {
}