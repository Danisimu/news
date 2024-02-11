//package com.example.News_service_REST_API.service.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.NewsCategory;
//import com.example.News_service_REST_API.repository.v1.NewsCategoryRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NewsCategoryService {
//
//    private final NewsCategoryRepository categoryRepository;
//
//    public List<NewsCategory> findAll(){
//        return categoryRepository.findAll();
//    }
//
//    public NewsCategory findById(Long id){
//        return categoryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Категория с ID {0} не найден", id)));
//
//    }
//
//    public NewsCategory save(NewsCategory newsCategory){
//        return categoryRepository.save(newsCategory);
//    }
//
//    public NewsCategory update(NewsCategory newsCategory){
//        return categoryRepository.update(newsCategory);
//    }
//
//    public void delete(Long id){
//        categoryRepository.delete(id);
//    }
//}
