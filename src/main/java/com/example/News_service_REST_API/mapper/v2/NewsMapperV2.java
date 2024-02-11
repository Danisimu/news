package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryListResponse;
import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryResponse;
import com.example.News_service_REST_API.web.model.news.NewsListResponse;
import com.example.News_service_REST_API.web.model.news.NewsResponse;
import com.example.News_service_REST_API.web.model.news.NewsResponseForFindById;
import com.example.News_service_REST_API.web.model.news.UpsertNewsRequest;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE
        )
@DecoratedWith(NewsMapperDelegate.class)
@Component
public interface NewsMapperV2 {

    News requestToNews(UpsertNewsRequest request);

    @Mapping(source = "newsId", target = "id")
    News requestToNews(Long newsId, UpsertNewsRequest request);

    @Mapping(source = "news", target = "userId", qualifiedByName = "userId")
    @Mapping(source = "news", target = "category", qualifiedByName = "category")
    @Mapping(source = "news", target = "numberOfComments", qualifiedByName = "setNumberOfComments")
    @Mapping(source = "news", target = "author", qualifiedByName = "setAuthor")
    NewsResponse newsToResponse(News news);


    @Mapping(source = "news", target = "userId", qualifiedByName = "userId")
    @Mapping(source = "news", target = "category", qualifiedByName = "category")
    @Mapping(source = "news", target = "numberOfComments", qualifiedByName = "setNumberOfComments")
    @Mapping(source = "news", target = "author", qualifiedByName = "setAuthor")
    @Mapping(source = "news", target = "commentaries", qualifiedByName = "setComments")
    NewsResponseForFindById newsToResponseForFindById(News news);


    List<NewsResponse> newsListToNewsList(List<News> news);

    @Mapping(source = "user", target = "userName", qualifiedByName = "setAuthorCommentary")
    @Mapping(source = "news", target = "newsId", qualifiedByName = "setNewsIdCommentary")
    NewsCommentaryResponse newsCommentaryToResponse(NewsCommentary commentary);


    default NewsListResponse newsListToNewsListResponse(List<News> news){
        NewsListResponse response = new NewsListResponse();
        response.setNewsList(newsListToNewsList(news));
        return response;
    }
    @Named("userId")
    default Long setUserId(News news) {
        return news.getUser().getId();
    }

    @Named("category")
    default String setCategory(News news){

        if (news.getCategory() != null) {
            return news.getCategory().getCategoryName();
        }
        return "";
    }
    @Named("setNumberOfComments")
    default int setNumberOfComments(News news){
        return news.getCommentaries().size();
    }

    @Named("setAuthor")
    default String setAuthor(News news){
        return news.getUser().getName();
    }
    
    @Named("setComments")
    default List<NewsCommentaryResponse> setComments(News news){
        List<NewsCommentaryResponse> response = new ArrayList<>();
        for (NewsCommentary commentary: news.getCommentaries()){
            response.add(newsCommentaryToResponse(commentary));
        }
        return  response;
    }

    @Named("setAuthorCommentary")
    default String setAuthor(User user){
        return user.getName();
    }

    @Named("setNewsIdCommentary")
    default Long setNewsId(News news){
        return news.getId();
    }



}
