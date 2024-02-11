package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.service.DatabaseNewsService;
import com.example.News_service_REST_API.service.DatabaseUserService;
import com.example.News_service_REST_API.web.model.commentary.UpsertNewsCommentaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class NewsCommentaryDelegate implements NewsCommentaryMapperV2{

    @Autowired
    private DatabaseNewsService newsService;

    @Autowired
    private DatabaseUserService userService;
    @Override
    public NewsCommentary requestToNewsCommentary(UpsertNewsCommentaryRequest request) {

        NewsCommentary commentary = new NewsCommentary();

        commentary.setCommentary(request.getCommentary());
        commentary.setNews(newsService.findById(request.getNewsId()));
        commentary.setUser(userService.findById(request.getUserId()));
        commentary.getNews().setId(request.getNewsId());

        return commentary;
    }

    @Override
    public NewsCommentary requestToNewsCommentary(Long commentaryId, UpsertNewsCommentaryRequest request) {

        NewsCommentary commentary = requestToNewsCommentary(request);
        commentary.setId(commentaryId);

        return commentary;
    }
}
