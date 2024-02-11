package com.example.News_service_REST_API.web.model.news;

import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryResponse;
import lombok.Data;

import java.util.List;
@Data
public class NewsResponseForFindById {

    private Long id;

    private String description;

    private Long userId;

    private int numberOfComments;

    private String category = "";

    private String author;

    private List<NewsCommentaryResponse> commentaries;
}
