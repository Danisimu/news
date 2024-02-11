package com.example.News_service_REST_API.web.model.commentary;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewsCommentaryListResponse {

    private List<NewsCommentaryResponse> commentaries = new ArrayList<>();
}
