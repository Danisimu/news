package com.example.News_service_REST_API.web.model.category;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewsCategoryListResponse {

    private List<NewsCategoryResponse> categories = new ArrayList<>();
}
