//package com.example.News_service_REST_API.mapper.v1;
//
//import com.example.News_service_REST_API.model.User;
//import com.example.News_service_REST_API.web.model.user.UpsertUserRequest;
//import com.example.News_service_REST_API.web.model.user.UserListResponse;
//import com.example.News_service_REST_API.web.model.user.UserResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class UserMapper {
//
//    private final NewsMapper newsMapper;
//
//    private final NewsCommentaryMapper commentaryMapper;
//
//    public User requestToUser(UpsertUserRequest request){
//        User user = new User();
//
//        user.setName(request.getName());
//
//        return user;
//    }
//
//    public User requestToUser(Long userId, UpsertUserRequest request){
//        User user = requestToUser(request);
//        user.setId(userId);
//
//        return user;
//    }
//
//    public UserResponse userToResponse(User user){
//        UserResponse userResponse = new UserResponse();
//
//        userResponse.setId(user.getId());
//        userResponse.setName(user.getName());
//        userResponse.setNewsResponses(newsMapper.newsListToResponseList(user.getNewsList()));
//        userResponse.setNewsCommentaryResponses(commentaryMapper.newsCommentaryResponseList(user.getCommentaryList()));
//
//        return userResponse;
//    }
//
//    public UserListResponse userListToClientResponseList(List<User> users){
//        UserListResponse response = new UserListResponse();
//
//        response.setUsers(users.stream()
//                .map(this::userToResponse).collect(Collectors.toList()));
//
//        return response;
//
//    }
//}
