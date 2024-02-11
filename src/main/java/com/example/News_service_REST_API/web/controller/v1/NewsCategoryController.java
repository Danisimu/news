//package com.example.News_service_REST_API.web.controller.v1;
//
//import com.example.News_service_REST_API.mapper.v1.NewsCategoryMapper;
//import com.example.News_service_REST_API.model.NewsCategory;
//import com.example.News_service_REST_API.service.v1.NewsCategoryService;
//import com.example.News_service_REST_API.web.model.category.NewsCategoryListResponse;
//import com.example.News_service_REST_API.web.model.category.NewsCategoryResponse;
//import com.example.News_service_REST_API.web.model.category.UpsertNewsCategoryRequest;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/category")
//public class NewsCategoryController {
//
//    private final NewsCategoryService categoryService;
//
//    private final NewsCategoryMapper categoryMapper;
//
//    @GetMapping
//    public ResponseEntity<NewsCategoryListResponse> findAll(){
//        return ResponseEntity.ok(
//                categoryMapper.newsCategoryListResponseToResponse(categoryService.findAll())
//        );
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<NewsCategoryResponse> findById(@PathVariable Long id){
//
//        return ResponseEntity.ok(
//                categoryMapper.newsCategoryToResponse(categoryService.findById(id))
//        );
//    }
//
//    @PostMapping()
//    public ResponseEntity<NewsCategoryResponse> create(@RequestBody @Valid UpsertNewsCategoryRequest request){
//        NewsCategory category = categoryService.save(categoryMapper.requestToNewsCategory(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(categoryMapper.newsCategoryToResponse(category));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<NewsCategoryResponse> update(@PathVariable Long id, @RequestBody @Valid UpsertNewsCategoryRequest request){
//
//        NewsCategory category = categoryService.update(categoryMapper.requestToNewsCategory(id,request));
//
//        return ResponseEntity.ok(
//                categoryMapper.newsCategoryToResponse(category)
//        );
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        categoryService.delete(id);
//
//        return ResponseEntity.noContent().build();
//    }
//}
