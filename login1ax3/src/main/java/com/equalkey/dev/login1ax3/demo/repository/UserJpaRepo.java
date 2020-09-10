package com.equalkey.dev.login1ax3.demo.repository;

import com.equalkey.dev.login1ax3.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Long> {
    Optional<User> findByUid(String account);
    Optional<User> findByAccountAndPassword(String account, String pwd);
}
