package com.equalkey.dev.login.repository;

import com.equalkey.dev.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepo extends JpaRepository<User, Long> {
}
