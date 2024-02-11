package com.example.News_service_REST_API.service;

import com.example.News_service_REST_API.exception.EntityNotFoundException;
import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.repository.DatabaseNewsCommentaryRepository;
import com.example.News_service_REST_API.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseNewsCommentaryService {

    private final DatabaseNewsCommentaryRepository commentaryRepository;

    private final DatabaseUserService userService;

    private final DatabaseNewsService newsService;

    public List<NewsCommentary> findALl(){
        return commentaryRepository.findAll();
    }

    public NewsCommentary findById(Long id){
        return commentaryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Комментарий с ID {0} не найден",id)));
    }

    public NewsCommentary create(NewsCommentary commentary){
        User user = userService.findById(commentary.getUser().getId());
        News news =newsService.findById(commentary.getNews().getId());

        commentary.setNews(news);
        commentary.setUser(user);

        return commentaryRepository.save(commentary);
    }

    public NewsCommentary update(NewsCommentary commentary){
        User user = userService.findById(commentary.getUser().getId());
        News news =newsService.findById(commentary.getNews().getId());

        NewsCommentary existedCommentary = findById(commentary.getId());

        BeanUtils.copyNonNullProperties(commentary, existedCommentary);

        existedCommentary.setUser(user);
        existedCommentary.setNews(news);

        return commentaryRepository.save(existedCommentary);
    }

    public void delete(Long id){
        commentaryRepository.deleteById(id);
    }
}
