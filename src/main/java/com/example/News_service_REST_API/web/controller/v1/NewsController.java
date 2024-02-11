//package com.example.News_service_REST_API.web.controller.v1;
//
//import com.example.News_service_REST_API.mapper.v1.NewsMapper;
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.service.v1.NewsService;
//import com.example.News_service_REST_API.web.model.news.NewsListResponse;
//import com.example.News_service_REST_API.web.model.news.NewsResponse;
//import com.example.News_service_REST_API.web.model.news.UpsertNewsRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/news")
//public class NewsController {
//
//    private final NewsService newsService;
//
//    private final NewsMapper newsMapper;
//
//    @GetMapping()
//    public ResponseEntity<NewsListResponse> findAll(){
//        return ResponseEntity.ok(
//                newsMapper.newsListToNewsListResponse(newsService.findAll())
//        );
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NewsResponse> findById(@PathVariable Long id){
//        return ResponseEntity.ok(
//                newsMapper.newsResponse(newsService.findById(id))
//        );
//    }
//
//    @PostMapping
//    public ResponseEntity<NewsResponse> create(@RequestBody @Valid UpsertNewsRequest request){
//        News news = newsService.save(newsMapper.requestToNews(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(newsMapper.newsResponse(news));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<NewsResponse> update(@PathVariable Long id, @RequestBody @Valid UpsertNewsRequest request){
//        News updatedNews = newsService.update(newsMapper.requestToNews(id, request));
//
//        return ResponseEntity.ok(newsMapper.newsResponse(updatedNews));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        newsService.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }
//}
