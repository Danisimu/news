package com.example.News_service_REST_API.mapper.v2;

import com.example.News_service_REST_API.model.NewsCategory;
import com.example.News_service_REST_API.web.model.category.UpsertNewsCategoryRequest;

public abstract class NewsCategoryDelegate implements NewsCategoryMapperV2{

    @Override
    public NewsCategory requestToNewsCategory(UpsertNewsCategoryRequest request) {
        NewsCategory category = new NewsCategory();
        category.setCategoryName(request.getCategory());
        category.setNewsId(request.getNewsId());

        return category;
    }

    @Override
    public NewsCategory requestToNewsCategory(Long categoryDd, UpsertNewsCategoryRequest request) {
        NewsCategory category = requestToNewsCategory(request);
        category.setId(categoryDd);

        return category;
    }
}
