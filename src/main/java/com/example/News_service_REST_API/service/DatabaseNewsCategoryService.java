package com.example.News_service_REST_API.service;

import com.example.News_service_REST_API.exception.EntityNotFoundException;
import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCategory;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.repository.DatabaseNewsCategoryRepository;
import com.example.News_service_REST_API.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseNewsCategoryService {

    private final DatabaseNewsCategoryRepository categoryRepository;

    private final DatabaseNewsService newsService;

    public List<NewsCategory> findAll(){
        return categoryRepository.findAll();
    }

    public NewsCategory findById(Long id){

        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Категория с ID {0} не найден",id)));

    }

    public  NewsCategory save(NewsCategory category){

        newsService.findById(category.getNewsId()).setCategory(category);
        return categoryRepository.save(category);
    }

    public NewsCategory update( NewsCategory category){

        NewsCategory existedCategory = findById(category.getId());

        BeanUtils.copyNonNullProperties(category, existedCategory);

        return categoryRepository.save(existedCategory);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

}
