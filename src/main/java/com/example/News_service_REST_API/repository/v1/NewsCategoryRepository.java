//package com.example.News_service_REST_API.repository.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.model.NewsCategory;
//import com.example.News_service_REST_API.utils.BeanUtils;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import java.text.MessageFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//@RequiredArgsConstructor
//@Getter
//public class NewsCategoryRepository {
//
//    private final Map<Long, NewsCategory> repository = new ConcurrentHashMap<>();
//
//    private final AtomicLong currentId = new AtomicLong(1);
//
//    private final NewsRepository newsRepository;
//
//
//
//    public List<NewsCategory> findAll(){
//        return new ArrayList<>(repository.values());
//    }
//
//    public Optional<NewsCategory> findById(Long id){
//        return Optional.ofNullable(repository.get(id));
//
//    }
//
//    public NewsCategory save(NewsCategory newsCategory){
//
//        News news = newsRepository.findById(newsCategory.getNewsId())
//                .orElseThrow(()->new EntityNotFoundException("Новость не найдена!"));
//
//        Long categoryId = currentId.getAndIncrement();
//        NewsCategory category = new NewsCategory();
//        category.setCategoryName(newsCategory.getCategoryName());
//        category.setId(categoryId);
//        category.setNewsId(newsCategory.getNewsId());
//
//        repository.put(categoryId, category);
//
//        return category;
//    }
//
//    public NewsCategory update(NewsCategory newsCategory){
//
//        Long categoryId = newsCategory.getId();
//        NewsCategory category = repository.get(categoryId);
//
//        if (category == null){
//            throw new EntityNotFoundException(MessageFormat.format("Категория с ID {0} не найдена", categoryId));
//        }
//
//        BeanUtils.copyNonNullProperties(newsCategory, category);
//
//        repository.put(newsCategory.getId(), category);
//
//        return category;
//
//    }
//
//    public void delete(Long id){
//        NewsCategory newsCategory = repository.get(id);
//
//        if (newsCategory == null){
//            throw new EntityNotFoundException(MessageFormat.format("Категория с ID {0} не найден", id));
//        }
//        repository.remove(id);
//    }
//}
