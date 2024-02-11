//package com.example.News_service_REST_API.web.controller.v1;
//
//import com.example.News_service_REST_API.mapper.v1.UserMapper;
//import com.example.News_service_REST_API.model.User;
//import com.example.News_service_REST_API.service.v1.UserService;
//import com.example.News_service_REST_API.web.model.user.UpsertUserRequest;
//import com.example.News_service_REST_API.web.model.user.UserListResponse;
//import com.example.News_service_REST_API.web.model.user.UserResponse;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/user")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//    private final UserMapper userMapper;
//
//    @GetMapping
//    public ResponseEntity<UserListResponse> findAll(){
//
//        return ResponseEntity.ok(
//                userMapper.userListToClientResponseList(userService.findAll())
//        );
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id){
//
//        return ResponseEntity.ok(
//                userMapper.userToResponse(userService.findById(id))
//        );
//    }
//    @PostMapping
//    public ResponseEntity<UserResponse> create(@RequestBody @Valid UpsertUserRequest request){
//        User newUser = userService.save(userMapper.requestToUser(request));
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(userMapper.userToResponse(newUser));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<UserResponse> update(@RequestBody @Valid UpsertUserRequest request, @PathVariable Long id){
//
//        System.out.println(id);
//        System.out.println(request);
//        User updatedUser =  userService.update(userMapper.requestToUser(id, request));
//
//        return ResponseEntity.ok(userMapper.userToResponse(updatedUser));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id){
//        userService.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }
//
//}
