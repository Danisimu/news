package com.example.News_service_REST_API.web.model.commentary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class UpsertNewsCommentaryRequest {

    @NotNull(message = "ID пользователя не должно быть пустым!")
    @Positive(message = "ID пользователя должно быть больше нуля!")
    private Long userId;

    @NotNull(message = "ID новости не должно быть пустым!")
    @Positive(message = "ID новости должно быть больше нуля!")
    private Long newsId;

    @NotBlank(message = "Комментарий не должен быть пустым!")
    private String commentary;





}
