package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    private Double value;
}
