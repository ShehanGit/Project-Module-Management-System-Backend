package com.ITPM.springbootbackend.repository;

import com.ITPM.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
