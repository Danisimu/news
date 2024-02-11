//package com.example.News_service_REST_API.service.v1;
//
//import com.example.News_service_REST_API.exception.EntityNotFoundException;
//import com.example.News_service_REST_API.model.User;
//import com.example.News_service_REST_API.repository.v1.NewsCommentaryRepository;
//import com.example.News_service_REST_API.repository.v1.NewsRepository;
//import com.example.News_service_REST_API.repository.v1.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.text.MessageFormat;
//import java.util.List;
//@Service
//@RequiredArgsConstructor
//public class UserService {
//
//
//    private final UserRepository userRepository;
//
//    private final NewsRepository newsRepository;
//
//    private final NewsCommentaryRepository commentaryRepository;
//
//    public List<User> findAll(){
//        return userRepository.findAll();
//   }
//
//   public User findById(Long id){
//       return userRepository.findById(id)
//               .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Пользователь по ID {0} не найден", id)));
//   }
//
//   public User save(User user){
//        return userRepository.save(user);
//   }
//
//   public User update(User user){
//        return userRepository.update(user);
//   }
//
//   public void deleteById(Long id){
//        User user = findById(id);
//        user.removeAllNews();
//        user.removeAllCommentary();
//        newsRepository.deleteNewsByUserId(id);
//        commentaryRepository.deleteCommentaryByNewsId(user.getId());
//
//
//        userRepository.deleteById(id);
//   }
//
//
//}
