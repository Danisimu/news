package com.example.News_service_REST_API.service;

import com.example.News_service_REST_API.exception.EntityNotFoundException;
import com.example.News_service_REST_API.model.News;
import com.example.News_service_REST_API.model.NewsCommentary;
import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.repository.DatabaseUserRepository;
import com.example.News_service_REST_API.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseUserService {

    private final DatabaseUserRepository userRepository;

    public List<User> findAll(){

        return userRepository.findAll();
    }

    public User findById(Long id){

        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Пользователь по ID {0} не найден", id)));
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){

        User existedUser = findById(user.getId());

        BeanUtils.copyNonNullProperties(user, existedUser);

        return userRepository.save(existedUser);
    }

    public void deleteById(Long id){



        userRepository.deleteById(id);
    }
}
