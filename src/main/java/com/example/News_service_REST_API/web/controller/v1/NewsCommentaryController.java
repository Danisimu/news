//package com.example.News_service_REST_API.web.controller.v1;
//
//import com.example.News_service_REST_API.mapper.v1.NewsCommentaryMapper;
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.service.v1.NewsCommentaryService;
//import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryListResponse;
//import com.example.News_service_REST_API.web.model.commentary.NewsCommentaryResponse;
//import com.example.News_service_REST_API.web.model.commentary.UpsertNewsCommentaryRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/commentary")
//public class NewsCommentaryController {
//
//
//    private final NewsCommentaryService commentaryService;
//
//    private final NewsCommentaryMapper commentaryMapper;
//
//    @GetMapping()
//    public ResponseEntity<NewsCommentaryListResponse> findAll(){
//        return ResponseEntity
//                .ok(commentaryMapper.newsCommentaryListToNewsCommentaryListResponse(commentaryService.findAll()));
//
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NewsCommentaryResponse> findById(@PathVariable Long id){
//        return ResponseEntity.ok(
//                commentaryMapper.commentaryResponse(commentaryService.findById(id))
//        );
//    }
//
//    @PostMapping
//    public ResponseEntity<NewsCommentaryResponse> create(@RequestBody @Valid UpsertNewsCommentaryRequest request){
//        NewsCommentary commentary = commentaryService.save(commentaryMapper.requestToNewsCommentary(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(commentaryMapper.commentaryResponse(commentary));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<NewsCommentaryResponse> update(@RequestBody @Valid UpsertNewsCommentaryRequest request, @PathVariable Long id){
//        NewsCommentary commentary = commentaryService.update(commentaryMapper.requestToNewsCommentary(request, id));
//
//        return ResponseEntity.ok(
//                commentaryMapper.commentaryResponse(commentary)
//        );
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        commentaryService.delete(id);
//
//        return ResponseEntity.noContent().build();
//    }
//}
