package com.example.nanda.service;

import com.example.nanda.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(Long id, UserEntity userEntity);
    void deleteById(Long id);
}
