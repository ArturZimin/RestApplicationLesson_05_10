package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save/user/post")
    public User saveUser(@RequestBody User user){
        if (user==null){
            return null;
        }

        return userService.saveUser(user);
    }

    @GetMapping("/get/user/{id}")
    public User getUserById(@PathVariable(name = "id") Integer id){
        if (id==null){
            return null;
        }

        return userService.getUserById(id);
    }

    @GetMapping("/get/all/users")
    public List<User> getAll(){

        return userService.getAllUsers();
    }


    @DeleteMapping ("/delete/by/id/{id}")
    public String deleteUserById(@PathVariable(name = "id") Integer id){
        return userService.deleteUserBuId(id);
    }

    @PutMapping("/update/by/id/")
    public List<User> updateUser(@RequestBody User user){

        return (List<User>) userService.updateUser(user);
    }
}
