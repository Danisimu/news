package com.example.News_service_REST_API.web.controller.v2;

import com.example.News_service_REST_API.mapper.v2.UserMapperV2;
import com.example.News_service_REST_API.model.User;
import com.example.News_service_REST_API.service.DatabaseUserService;
import com.example.News_service_REST_API.web.model.user.UpsertUserRequest;
import com.example.News_service_REST_API.web.model.user.UserListResponse;
import com.example.News_service_REST_API.web.model.user.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/user")
@RequiredArgsConstructor
public class UserControllerV2 {

    private final DatabaseUserService databaseUserService;

    private final UserMapperV2 userMapper;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll(){
        return ResponseEntity.ok(
                userMapper.userListToUserResponseList(databaseUserService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                userMapper.userToResponse(databaseUserService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UpsertUserRequest request){
        User user = databaseUserService.save(userMapper.requestToUser(request));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.userToResponse(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update (@PathVariable Long id, @RequestBody @Valid UpsertUserRequest request){
        User user = databaseUserService.update(userMapper.requestToUser(id, request));

        return ResponseEntity.ok(
                userMapper.userToResponse(user)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> delete(@PathVariable Long id ){
        databaseUserService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
