package com.example.demo.service;

import com.example.demo.bean.UserRequest;
import com.example.demo.model.User;

public interface UserService {
    void save(User user);

    Double salaryInPaperUsd(Double byn);
    Double salaryInPaperEur(Double byn);

    void saveUser(UserRequest userRequest);
}
