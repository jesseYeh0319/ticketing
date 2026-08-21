package io.github.jesseYeh0319.ticketing.user.repository;

import io.github.jesseYeh0319.ticketing.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}