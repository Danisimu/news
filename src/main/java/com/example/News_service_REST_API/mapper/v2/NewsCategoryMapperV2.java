package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.NewsCategory;
import com.example.News_service_REST_API.web.model.category.NewsCategoryListResponse;
import com.example.News_service_REST_API.web.model.category.NewsCategoryResponse;
import com.example.News_service_REST_API.web.model.category.UpsertNewsCategoryRequest;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {NewsMapperV2.class})
@DecoratedWith(NewsCategoryDelegate.class)
@Component
public interface NewsCategoryMapperV2 {

    NewsCategory requestToNewsCategory(UpsertNewsCategoryRequest request);

    @Mapping(source = "categoryId", target = "id")
    NewsCategory requestToNewsCategory(Long categoryId, UpsertNewsCategoryRequest request);

    @Mapping(source = "category", target = "category", qualifiedByName = "categoryName")
    NewsCategoryResponse newsCategoryResponseToResponse(NewsCategory category);

    List<NewsCategoryResponse> newsCategoryResponseListToResponse(List<NewsCategory> categoryList);

    default NewsCategoryListResponse newsCategoryListResponseToResponse(List<NewsCategory> categoryList){
        NewsCategoryListResponse categoryListResponse = new NewsCategoryListResponse();
        categoryListResponse.setCategories(newsCategoryResponseListToResponse(categoryList));

        return categoryListResponse;
    }

    @Named("categoryName")
    default String  setCategoryName(NewsCategory category){
        return category.getCategoryName();
    }
}
