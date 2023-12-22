package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getUsers();

    User updatePerson(User user, Long id);
}
