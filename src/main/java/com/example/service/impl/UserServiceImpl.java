package com.example.service.impl;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usermapper;


    @Override
    public List<User> getUsers() {
        return usermapper.findAllUser();
    }

    @Override
    public User getUseById(int id) {
        return usermapper.findUserById(id);
    }
}
