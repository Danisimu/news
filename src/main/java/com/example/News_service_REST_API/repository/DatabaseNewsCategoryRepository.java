package com.example.News_service_REST_API.repository;

import com.example.News_service_REST_API.model.NewsCategory;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseNewsCategoryRepository extends JpaRepository<NewsCategory, Long> {
}
