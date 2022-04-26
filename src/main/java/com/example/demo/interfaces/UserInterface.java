package com.example.demo.interfaces;

import com.example.demo.entity.User;

import java.util.List;

public interface UserInterface {
    String login(Integer userId, String password);
    List<User> getUserById(Integer userId);
    String editUserById(Integer userId,String userName,String password,String userAddress,String storeName);
}
