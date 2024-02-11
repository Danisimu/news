package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.service.DatabaseUserService;
import com.example.News_service_REST_API.web.model.news.NewsResponse;
import com.example.News_service_REST_API.web.model.news.UpsertNewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public abstract class NewsMapperDelegate implements NewsMapperV2{

    @Autowired
    private DatabaseUserService databaseUserService;

    @Override
    public News requestToNews(UpsertNewsRequest request) {

        News news = new News();
       news.setDescription(request.getDescription());
       news.setUser(databaseUserService.findById(request.getUserId()));

       return news;
    }

    @Override
    public News requestToNews(Long newsId, UpsertNewsRequest request) {

        News news = requestToNews(request);
        news.setId(newsId);

        return news;
    }


}
