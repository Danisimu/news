package com.example.News_service_REST_API.web.model.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpsertUserRequest {

    @NotBlank(message = "Имя пользователя должно быть заполнено")
    private String name;
}
