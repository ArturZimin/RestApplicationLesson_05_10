package com.example.demo.repository;

import com.example.demo.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    List<Salary> findByValueGreaterThan(Double number);
}
