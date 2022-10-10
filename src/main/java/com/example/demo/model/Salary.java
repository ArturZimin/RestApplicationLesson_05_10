package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
    @Column(name="user_id")
    private Integer userId;
}
