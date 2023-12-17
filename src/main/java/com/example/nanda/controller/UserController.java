package com.example.nanda.controller;

import com.example.nanda.entity.UserEntity;
import com.example.nanda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers(){
         List<UserEntity> userEntities = userService.getAllUsers();

         if(userEntities!=null){
             return ResponseEntity.status(200).body(userEntities);
         }else {
             return ResponseEntity.status(404).body(null);
         }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id){
        UserEntity userEntity = userService.getUserById(id);

        if(userEntity!=null){
            return ResponseEntity.status(200).body(userEntity);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity userEntity){
        return userService.createUser(userEntity);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity){
        UserEntity entity = userService.updateUser(id,userEntity);

        if(entity!=null){
            return ResponseEntity.status(200).body(entity);
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
