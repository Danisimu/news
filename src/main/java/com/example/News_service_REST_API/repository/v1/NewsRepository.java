//package com.example.News_service_REST_API.repository.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.model.User;
//import com.example.News_service_REST_API.utils.BeanUtils;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import java.text.MessageFormat;
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//@Getter
//public class NewsRepository {
//
//
//    private UserRepository userRepository;
//
//    private final Map<Long, News> repository = new ConcurrentHashMap<>();
//
//    private final AtomicLong currentId = new AtomicLong(1);
//
//
//    public List<News> findAll(){
//        return new ArrayList<>(repository.values());
//    }
//
//    public Optional<News> findById(Long id){
//
//        return Optional.ofNullable(repository.get(id));
//    }
//
//    public News save(News news){
//
//        Long newsId = currentId.getAndIncrement();
//        Long userId = news.getUser().getId();
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(()-> new EntityNotFoundException("Пользователь не найден!"));
//
//        news.setUser(user);
//        news.setId(newsId);
//        Instant now = Instant.now();
//
//
//        repository.put(newsId, news);
//
//        user.addNews(news);
//
//        userRepository.update(user);
//
//        return news;
//    }
//
//    public News update(News news){
//
//        Long newsId = news.getId();
//        Instant now = Instant.now();
//        News currentNews = repository.get(newsId);
//        if (currentNews == null){
//            throw new EntityNotFoundException(MessageFormat.format("Новость по ID {0} не найден", newsId));
//        }
//        BeanUtils.copyNonNullProperties(news, currentNews);
//        currentNews.setId(newsId);
//
//
//        repository.put(newsId, currentNews);
//
//        return currentNews;
//
//    }
//
//    public void deleteById(Long id){
//        News currentNews = repository.get(id);
//        if (currentNews == null){
//            throw new EntityNotFoundException(MessageFormat.format("Новость по ID {0} не найден", id));
//        }
//
//        repository.remove(id);
//
//    }
//
//    public void deleteNewsByUserId(Long userId){
//        for (News news: repository.values()){
//            if (news.getUser().getId().equals(userId)){
//                repository.remove(news.getId());
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
//}
