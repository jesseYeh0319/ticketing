package io.github.jesseYeh0319.ticketing.order.repository;

import io.github.jesseYeh0319.ticketing.order.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}