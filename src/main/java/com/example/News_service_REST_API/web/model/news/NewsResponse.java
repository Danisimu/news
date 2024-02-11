package com.example.News_service_REST_API.web.model.news;

import lombok.Data;

@Data
public class NewsResponse {

    private Long id;

    private String description;

    private Long userId;

    private int numberOfComments;

    private String category = "";

    private String author;





}
