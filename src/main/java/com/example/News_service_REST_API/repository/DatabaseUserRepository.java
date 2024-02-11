package com.example.News_service_REST_API.repository;

import com.example.News_service_REST_API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseUserRepository extends JpaRepository<User, Long> {
}
