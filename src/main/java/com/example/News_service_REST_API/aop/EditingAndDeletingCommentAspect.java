package com.example.News_service_REST_API.aop;

import com.example.News_service_REST_API.exception.EntityNotFoundException;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.service.DatabaseNewsCommentaryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class EditingAndDeletingCommentAspect {

    @Autowired
    private DatabaseNewsCommentaryService commentaryService;


    @Before("@annotation(EditingAndDeletingComment)")
    public void editingAndDeletingCommentBefore(JoinPoint joinPoint){
        Object[] parameter = joinPoint.getArgs();

        NewsCommentary commentary = commentaryService.findById((Long) parameter[0]);

        if (commentary.getUser().getId().equals(parameter[1])){
            return;
        }

        throw new EntityNotFoundException("Редактировать может только пользователь, написавший комментарий!");
    }
}
