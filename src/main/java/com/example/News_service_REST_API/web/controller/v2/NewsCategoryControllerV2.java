package com.example.News_service_REST_API.web.controller.v2;

import com.example.News_service_REST_API.mapper.v2.NewsCategoryMapperV2;
import com.example.News_service_REST_API.model.NewsCategory;
import com.example.News_service_REST_API.service.DatabaseNewsCategoryService;
import com.example.News_service_REST_API.web.model.category.NewsCategoryListResponse;
import com.example.News_service_REST_API.web.model.category.NewsCategoryResponse;
import com.example.News_service_REST_API.web.model.category.UpsertNewsCategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/category")
@RequiredArgsConstructor
public class NewsCategoryControllerV2 {

    private final DatabaseNewsCategoryService categoryService;

    private final NewsCategoryMapperV2 categoryMapper;

    @GetMapping
    public ResponseEntity<NewsCategoryListResponse> findAll(){
        return ResponseEntity.ok(
                categoryMapper.newsCategoryListResponseToResponse(categoryService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsCategoryResponse> findById(@PathVariable @Valid Long id){
        return ResponseEntity.ok(
                categoryMapper.newsCategoryResponseToResponse(categoryService.findById(id))
        );
    }

    @PostMapping()
    public ResponseEntity<NewsCategoryResponse> create(@RequestBody @Valid UpsertNewsCategoryRequest request)
    {
        NewsCategory category = categoryService.save(categoryMapper.requestToNewsCategory(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryMapper.newsCategoryResponseToResponse(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsCategoryResponse> update(@RequestBody @Valid UpsertNewsCategoryRequest request,
                                                       @PathVariable Long id) {
        NewsCategory category = categoryService.update(categoryMapper.requestToNewsCategory(id, request));
        return ResponseEntity.ok(
                categoryMapper.newsCategoryResponseToResponse(category)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NewsCategoryResponse> delete(@PathVariable @Valid Long id){
        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
