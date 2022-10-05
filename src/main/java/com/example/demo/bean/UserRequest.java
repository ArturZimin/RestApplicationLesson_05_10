package com.example.demo.bean;

import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Integer id;
    private String name;
    private String salary;
    private List<Integer> carIdList;
    private List<User> childList;
}
