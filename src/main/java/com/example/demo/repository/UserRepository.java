package com.example.demo.repository;

import com.example.demo.bean.UserDtoRequest;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

User findByName(String name);



    List<User> findByNameOrName(String name, String name2);
}
