package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryListResponse;
import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryResponse;
import com.example.News_service_REST_API.web.model.commentary.UpsertNewsCommentaryRequest;
import org.mapstruct.*;


import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
                                        uses ={UserMapperV2.class} )
@DecoratedWith(NewsCommentaryDelegate.class)
public interface NewsCommentaryMapperV2 {

    NewsCommentary requestToNewsCommentary(UpsertNewsCommentaryRequest request);

    @Mapping(source = "commentaryId", target = "id")
    NewsCommentary requestToNewsCommentary(Long commentaryId, UpsertNewsCommentaryRequest request);

    @Mapping(source = "user", target = "userName", qualifiedByName = "setUserName")
    @Mapping(source = "news", target = "newsId", qualifiedByName = "setNewsId")
    @Mapping(source = "user", target = "userId", qualifiedByName = "setUserId")
    NewsCommentaryResponse newsCommentaryToResponses(NewsCommentary commentary);


    List<NewsCommentaryResponse> newsCommentaryResponseListToResponse(List<NewsCommentary> commentaries);

    default NewsCommentaryListResponse newsCommentaryListResponse(List<NewsCommentary> commentaries){
        NewsCommentaryListResponse response = new NewsCommentaryListResponse();
        response.setCommentaries(newsCommentaryResponseListToResponse(commentaries));

        return response;
    }

    @Named("setUserName")
    default String setUserName(User user){
        return user.getName();
    }
    @Named("setNewsId")
    default Long setNewsId(News news){
        return news.getId();
    }
    @Named("setUserId")
    default Long setUserId(User user){
        return user.getId();
    }




}
