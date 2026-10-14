package com.ali.msusers.repository;

import com.ali.msusers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
