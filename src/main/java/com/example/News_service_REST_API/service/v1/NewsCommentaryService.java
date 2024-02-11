//package com.example.News_service_REST_API.service.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.repository.v1.NewsCommentaryRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NewsCommentaryService {
//
//    private final NewsCommentaryRepository newsCommentaryRepository;
//
//    public List<NewsCommentary> findAll(){
//       return newsCommentaryRepository.findAll();
//    }
//
//    public NewsCommentary findById(Long id){
//        return newsCommentaryRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Комментарий по ID {0} не найдена", id)));
//    }
//
//    public NewsCommentary save(NewsCommentary newsCommentary){
//        return newsCommentaryRepository.save(newsCommentary);
//    }
//
//    public NewsCommentary update(NewsCommentary newsCommentary){
//        return newsCommentaryRepository.update(newsCommentary);
//    }
//
//    public void delete(Long id){
//
//        NewsCommentary currentCommentary = findById(id);
//        currentCommentary.getUser().removeCommentary(id);
//        newsCommentaryRepository.delete(id);
//        currentCommentary.getNews().removeCommentary(id);
//
//    }
//
//}
