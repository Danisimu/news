//package com.example.News_service_REST_API.repository.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.News;
//import com.example.News_service_REST_API.model.User;
//import com.example.News_service_REST_API.utils.BeanUtils;
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
//import java.util.stream.Collectors;
//
//@Component
//public class UserRepository {
//
//    private NewsRepository newsRepository;
//
//    private final Map<Long, User> repository = new ConcurrentHashMap<>();
//
//    private final AtomicLong currentId = new AtomicLong(1);
//
//    public List<User> findAll(){
//        return new ArrayList<>(repository.values());
//    }
//
//    public Optional<User> findById(Long id){
//        return Optional.ofNullable(repository.get(id));
//    }
//
//    public User save(User user){
//        Long userId = currentId.getAndIncrement();
//        user.setId(userId);
//        repository.put(userId, user);
//        return user;
//    }
//
//    public User update(User user){
//        Long userId = user.getId();
//        User currentUser = repository.get(userId);
//        if (currentUser == null){
//            throw new EntityNotFoundException(MessageFormat.format("Пользователь по ID {0} не найден", userId));
//        }
//
//        BeanUtils.copyNonNullProperties(user, currentUser);
//        currentUser.setId(userId);
//
//        repository.put(userId, currentUser);
//
//        return currentUser;
//
//    }
//
//    public void deleteById(Long id){
//        User currentUser = repository.get(id);
//        if (currentUser == null){
//            throw new EntityNotFoundException(MessageFormat.format("Пользователь по ID {0} не найден", id));
//        }
//
//        newsRepository.deleteByIdIn(currentUser.getNewsList().stream().map(News::getId).collect(Collectors.toList()));
//        repository.remove(id);
//    }
//    @Autowired
//    public void setNewsRepository(NewsRepository newsRepository){
//        this.newsRepository = newsRepository;
//    }
//}
