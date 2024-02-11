package com.example.News_service_REST_API.repository;

import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.web.model.filter.NewsFilter;
import org.springframework.data.jpa.domain.Specification;

public interface NewsSpecification {

    static Specification<News> withFilter(NewsFilter newsFilter){
        return Specification.where(byCategory(newsFilter.getCategoryName()))
                .and(byAuthor(newsFilter.getAuthor()));
    }

    static Specification<News> byCategory(String categoryName) {
        return (root, query, cb) -> {
            if(categoryName == null){
                return null;
            }
            return cb.equal(root.get("category").get("categoryName"), categoryName);
        };
    }

    static Specification<News> byAuthor(String author){
        return (root, query, cb) -> {
            if (author == null){
                return null;
            }
            return cb.equal(root.get("user").get("name"), author);
        };
    }
}
