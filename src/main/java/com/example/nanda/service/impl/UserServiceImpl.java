package com.example.nanda.service.impl;

import com.example.nanda.entity.UserEntity;
import com.example.nanda.repository.UserRepository;
import com.example.nanda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        UserEntity exist = userRepository.findById(id).orElse(null);
        if(exist!=null){
            exist.setName(userEntity.getName());
            exist.setEmail(userEntity.getEmail());
            exist.setPassword(userEntity.getPassword());

            return userRepository.save(exist);
        }else {
            return null;
        }

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
