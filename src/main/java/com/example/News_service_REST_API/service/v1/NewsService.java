//package com.example.News_service_REST_API.service.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.repository.v1.NewsCommentaryRepository;
//import com.example.News_service_REST_API.repository.v1.NewsRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NewsService {
//
//    private final NewsRepository newsRepository;
//
//    private final NewsCommentaryRepository commentaryRepository;
//
//    public List<News> findAll(){
//        return newsRepository.findAll();
//    }
//
//    public News findById(Long id){
//
//        return newsRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Новость по ID {0} не найдена", id)));
//    }
//
//    public News save(News news){
//        return newsRepository.save(news);
//    }
//
//    public News update(News news){
//        return newsRepository.update(news);
//    }
//
//    public void deleteById(Long id){
//        News currentNews = findById(id);
//        currentNews.getUser().removeNews(id);
//
//        for (NewsCommentary newsCommentary: currentNews.getCommentaries()){
//            for (NewsCommentary userCommentary: currentNews.getCommentaries()){
//                if (newsCommentary.getId().equals(userCommentary.getId())){
//                    currentNews.getUser().removeCommentary(newsCommentary.getId());
//                }
//            }
//
//        }
//
//        newsRepository.deleteById(id);
//    }
//
//    public void deleteByIdIn(List<Long> ids){
//        newsRepository.deleteByIdIn(ids);
//    }
//
//    public void deleteNewsByUserId(Long userId){
//        newsRepository.deleteNewsByUserId(userId);
//    }
//
//
//}
