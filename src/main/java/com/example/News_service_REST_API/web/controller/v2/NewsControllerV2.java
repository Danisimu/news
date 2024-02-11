package com.example.News_service_REST_API.web.controller.v2;

import com.example.News_service_REST_API.aop.EditingAndDeletingNews;
import com.example.News_service_REST_API.mapper.v2.NewsMapperV2;
import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.service.DatabaseNewsService;
import com.example.News_service_REST_API.web.model.filter.NewsFilter;
import com.example.News_service_REST_API.web.model.news.NewsListResponse;
import com.example.News_service_REST_API.web.model.news.NewsResponse;
import com.example.News_service_REST_API.web.model.news.NewsResponseForFindById;
import com.example.News_service_REST_API.web.model.news.UpsertNewsRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/news")
@RequiredArgsConstructor
public class NewsControllerV2 {

    private final DatabaseNewsService newsService;

    private final NewsMapperV2 newsMapperV2;

    @GetMapping("/filter")
    public ResponseEntity<NewsListResponse> filterBy(@Valid NewsFilter filter){

        return ResponseEntity.ok(
                newsMapperV2.newsListToNewsListResponse(
                        newsService.filterBy(filter)
                )
        );
    }

    @GetMapping
    public ResponseEntity<NewsListResponse> findAll(){

        return ResponseEntity.ok(
                newsMapperV2.newsListToNewsListResponse(newsService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponseForFindById> findById(@PathVariable("id") @Valid Long newsId){
        return ResponseEntity.ok(
                newsMapperV2.newsToResponseForFindById(newsService.findById(newsId))
        );
    }

    @PostMapping
    public ResponseEntity<NewsResponse> create(@RequestBody @Valid UpsertNewsRequest request){
        News news = newsService.save(newsMapperV2.requestToNews(request));
        return ResponseEntity.ok(
                newsMapperV2.newsToResponse(news)
        );
    }

    @PutMapping("/{id}/{userId}")
    @EditingAndDeletingNews
    public ResponseEntity<NewsResponse> update(@PathVariable("id") @Valid Long newsId,
                                               @PathVariable("userId") Long userId,
                                               @RequestBody @Valid UpsertNewsRequest request){

        News news = newsService.update(newsMapperV2.requestToNews(newsId, request));

        return ResponseEntity.ok(
                newsMapperV2.newsToResponse(news)
        );
    }

    @DeleteMapping("/{id}/{userId}")
    @EditingAndDeletingNews
    public ResponseEntity<NewsResponse> delete(@PathVariable("id") @Valid Long newsId,
                                               @PathVariable("userId") Long userId){

        newsService.deleteById(newsId);

        return ResponseEntity.noContent().build();
    }


}
