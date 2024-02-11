//package com.example.News_service_REST_API.mapper.v1;
//
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.model.NewsCategory;
//import com.example.News_service_REST_API.repository.v1.NewsCategoryRepository;
//import com.example.News_service_REST_API.repository.v1.NewsCommentaryRepository;
//import com.example.News_service_REST_API.service.v1.UserService;
//import com.example.News_service_REST_API.web.model.news.NewsListResponse;
//import com.example.News_service_REST_API.web.model.news.NewsResponse;
//import com.example.News_service_REST_API.web.model.news.UpsertNewsRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class NewsMapper {
//
//    private  final UserService userService;
//
//    private final NewsCommentaryRepository commentaryRepository;
//
//    private final NewsCategoryRepository categoryRepository;
//
//    private final NewsCommentaryMapper commentaryMapper;
//
//    public News requestToNews(UpsertNewsRequest request){
//        News news = new News();
//
//        news.setDescription(request.getDescription());
//        news.setUser(userService.findById(request.getUserId()));
//
//
//        return news;
//    }
//
//    public News requestToNews(Long newsId, UpsertNewsRequest request){
//        News news = requestToNews(request);
//        news.setId(newsId);
//
//        return news;
//
//    }
//
//    public NewsResponse newsResponse(News news){
//        NewsResponse newsResponse = new NewsResponse();
//
//        newsResponse.setId(news.getId());
//        newsResponse.setDescription(news.getDescription());
//        newsResponse.setNumberOfComments(
//                commentaryMapper.newsCommentaryResponseList(news.getCommentaries()).size());
//
//
//
//        return newsResponse;
//    }
//
//    public List<NewsResponse> newsListToResponseList(List<News> news){
//        return news.stream()
//                .map(this::newsResponse)
//                .collect(Collectors.toList());
//    }
//
//    public NewsListResponse newsListToNewsListResponse(List<News> news){
//        NewsListResponse response = new NewsListResponse();
//        response.setNewsList(newsListToResponseList(news));
//
//        return response;
//    }
//}
