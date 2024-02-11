//package com.example.News_service_REST_API.repository.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.model.NewsCommentary;
//import com.example.News_service_REST_API.model.User;
//import com.example.News_service_REST_API.utils.BeanUtils;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
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
//public class NewsCommentaryRepository {
//
//    private final Map<Long, NewsCommentary> repository = new ConcurrentHashMap<>();
//    private final AtomicLong currentId = new AtomicLong(1);
//
//    private UserRepository userRepository;
//
//    private NewsRepository newsRepository;
//
//    public List<NewsCommentary> findAll(){
//        return  new ArrayList<>(repository.values());
//    }
//
//    public Optional<NewsCommentary> findById(Long id){
//        return Optional.ofNullable(repository.get(id));
//
//    }
//
//    public NewsCommentary save(NewsCommentary newsCommentary){
//
//
//        Long commentaryId = currentId.getAndIncrement();
//        Long userId = newsCommentary.getUser().getId();
//        Long newsId = newsCommentary.getNews().getId();
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(()->new EntityNotFoundException("Пользователь не найден!"));
//
//        News news = newsRepository.findById(newsId)
//                .orElseThrow(()->new EntityNotFoundException("Новость не найдена!"));
//
//        NewsCommentary newCommentary = new NewsCommentary();
//
//        newCommentary.setCommentary(newsCommentary.getCommentary());
//        newCommentary.setId(commentaryId);
//        newCommentary.setUser(user);
//        newCommentary.setNews(news);
//
//        repository.put(commentaryId, newCommentary);
//
//        user.addCommentary(newCommentary);
//        userRepository.update(user);
//
//        news.addCommentary(newCommentary);
//        newsRepository.update(news);
//
//
//        return newCommentary;
//    }
//
//    public NewsCommentary update(NewsCommentary newsCommentary){
//
//        Long commentaryId = newsCommentary.getId();
//        NewsCommentary currentCommentary = repository.get(commentaryId);
//
//        if (currentCommentary == null){
//            throw new EntityNotFoundException(MessageFormat.format("Комментарий с ID {0} не найден", commentaryId));
//        }
//
//        BeanUtils.copyNonNullProperties(newsCommentary, currentCommentary);
//
//        repository.put(commentaryId, newsCommentary);
//
//        return currentCommentary;
//    }
//
//    public void delete(Long id){
//        NewsCommentary commentary = repository.get(id);
//
//        if (commentary == null){
//            throw new EntityNotFoundException(MessageFormat.format("Комментарий с ID {0} не найден", id));
//        }
//        repository.remove(id);
//    }
//
//    public void deleteCommentaryByNewsId(Long userId){
//
//        for (NewsCommentary commentary: repository.values()){
//            if (commentary.getUser().getId().equals(userId)){
//                repository.remove(commentary.getId());
//            }
//        }
//    }
//
//    public void deleteByIdIn(List<Long> ids){
//        ids.forEach(repository::remove);
//    }
//    @Autowired
//    public void setUserRepository(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//    @Autowired
//    public void setNewsRepository(NewsRepository newsRepository){
//        this.newsRepository = newsRepository;
//    }
//}
