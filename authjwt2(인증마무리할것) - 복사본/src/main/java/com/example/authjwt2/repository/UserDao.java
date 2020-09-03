package com.example.authjwt2.repository;

import com.example.authjwt2.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<DAOUser, Integer> {
    public Optional<DAOUser> findByUsername(String username);
}