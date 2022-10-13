package com.example.demo.service;

import com.example.demo.bean.UserDtoRequest;
import com.example.demo.bean.UserRequest;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
   User saveUser(User user);
   User getUserById(Integer id);

   List<User> getAllUsers();

   String deleteUserBuId(Integer id);


   Object updateUser(User user);

   User findUserByName(String name);



   List<User> getTwoUsers(String name, String name2);
}
