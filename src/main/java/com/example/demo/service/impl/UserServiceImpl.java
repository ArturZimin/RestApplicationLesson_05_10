package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public String deleteUserBuId(Integer id) {
        try{
            userRepository.delete(userRepository.findById(id).get());
          return "OK";
        }catch (Exception e){
            return "Not OK";
        }

    }

    @Override
    public Object updateUser(User user) {
        if (user.getId()!=null){
            saveUser(user);
        }
        return getAllUsers();
    }


}
