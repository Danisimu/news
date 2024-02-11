package com.example.News_service_REST_API.repository;

import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCommentary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatabaseNewsCommentaryRepository extends JpaRepository<NewsCommentary, Long> {


}
