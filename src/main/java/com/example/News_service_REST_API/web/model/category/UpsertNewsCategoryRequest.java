package com.example.News_service_REST_API.web.model.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpsertNewsCategoryRequest {

    @NotBlank(message = "Название категории не должно быть пустым!")
    private String category;

    @NotNull(message = "ID не должно быть пустым!")
    @Positive(message = "ID новости должно быть больше нуля!")
    private Long newsId;
}
