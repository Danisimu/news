package com.example.News_service_REST_API.web.model.filter;

import com.example.News_service_REST_API.validation.NewsFilterValid;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@NewsFilterValid
public class NewsFilter {

    private Integer pageSize;

    private Integer pageNumber;

    private String categoryName;

    private String author;
}
