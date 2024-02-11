package com.example.News_service_REST_API.web.model.news;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpsertNewsRequest {

    @NotNull(message = "ID пользователя не должно быть пустым!")
    @Positive(message = "ID пользователя должно быть больше нуля!")
    private Long userId;

    @NotBlank(message = "Описание должно быть заполнено")
    private String description;




}
