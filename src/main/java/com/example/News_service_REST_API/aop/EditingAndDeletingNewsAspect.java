package com.example.News_service_REST_API.aop;

import com.example.News_service_REST_API.exception.EntityNotFoundException;
import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.service.DatabaseNewsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EditingAndDeletingNewsAspect {

    @Autowired
    private DatabaseNewsService newsService;

    @Before("@annotation(EditingAndDeletingNews)")
    public void editingAndDeletingCommentBefore(JoinPoint joinPoint){
        Object[] parameter = joinPoint.getArgs();

        News news = newsService.findById((Long) parameter[0]);

        if (news.getUser().getId().equals(parameter[1])){
            return;
        }
        throw new EntityNotFoundException("Редактировать может только пользователь, написавший новость!");
    }
}
