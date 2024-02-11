//package com.example.News_service_REST_API.mapper.v1;
//
//import com.example.News_service_REST_API.model.NewsCategory;
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.web.model.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class NewsCategoryMapper {
//
//    public NewsCategory requestToNewsCategory(UpsertNewsCategoryRequest request){
//        NewsCategory category = new NewsCategory();
//        category.setCategoryName(request.getCategory());
//        category.setNewsId(request.getNewsId());
//
//
//        return category;
//    }
//
//    public NewsCategory requestToNewsCategory(Long id, UpsertNewsCategoryRequest request){
//        NewsCategory category = requestToNewsCategory(request);
//        category.setId(id);
//
//        return category;
//    }
//
//    public NewsCategoryResponse newsCategoryToResponse(NewsCategory category){
//
//        NewsCategoryResponse response = new NewsCategoryResponse();
//
//        response.setId(category.getId());
//        response.setCategory(category.getCategoryName());
//
//        return response;
//
//    }
//
//    public List<NewsCategoryResponse> newsCategoryResponseListToResponse(List<NewsCategory> categoryList){
//
//        return categoryList.stream()
//                .map(this::newsCategoryToResponse)
//                .collect(Collectors.toList());
//    }
//
//    public NewsCategoryListResponse newsCategoryListResponseToResponse(List<NewsCategory> categoryList){
//
//        NewsCategoryListResponse response = new NewsCategoryListResponse();
//        response.setCategories(newsCategoryResponseListToResponse(categoryList));
//
//        return response;
//
//    }
//}
