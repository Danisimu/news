//package com.example.News_service_REST_API.mapper.v1;
//
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.service.v1.NewsService;
//import com.example.News_service_REST_API.service.v1.UserService;
//import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryListResponse;
//import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryResponse;
//import com.example.News_service_REST_API.web.model.commentary.UpsertNewsCommentaryRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class NewsCommentaryMapper {
//
//
//    private final NewsService newsService;
//
//    private final UserService userService;
//
//
//
//    public NewsCommentary requestToNewsCommentary(UpsertNewsCommentaryRequest request){
//
//        NewsCommentary commentary = new NewsCommentary();
//
//        commentary.setCommentary(request.getCommentary());
//        commentary.setNews(newsService.findById(request.getNewsId()));
//        commentary.setUser(userService.findById(request.getUserId()));
//        commentary.getNews().setId(request.getNewsId());
//
//
//        return commentary;
//
//    }
//
//    public NewsCommentary requestToNewsCommentary(UpsertNewsCommentaryRequest request, Long id){
//
//        NewsCommentary commentary = requestToNewsCommentary(request);
//
//        commentary.setId(id);
//
//        return commentary;
//    }
//
//    public NewsCommentaryResponse commentaryResponse(NewsCommentary newsCommentary){
//        NewsCommentaryResponse response = new NewsCommentaryResponse();
//
//        response.setId(newsCommentary.getId());
//        response.setCommentary(newsCommentary.getCommentary());
//        response.setUserName(newsCommentary.getUser().getName());
//        response.setNewsId(newsCommentary.getNews().getId());
//
//        return response;
//    }
//
//    public List<NewsCommentaryResponse> newsCommentaryResponseList(List<NewsCommentary> newsCommentaryList){
//        return newsCommentaryList.stream()
//                .map(this::commentaryResponse)
//                .collect(Collectors.toList());
//    }
//
//    public NewsCommentaryListResponse newsCommentaryListToNewsCommentaryListResponse(List<NewsCommentary> newsCommentaryList){
//
//        NewsCommentaryListResponse response = new NewsCommentaryListResponse();
//        response.setCommentaryResponseList(newsCommentaryResponseList(newsCommentaryList));
//
//        return response;
//    }
//}
