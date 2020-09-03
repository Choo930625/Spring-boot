package com.example.authjwt2.repository;

import com.example.authjwt2.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Token, Long> {
}
