package com.example.demo.service;

import com.example.demo.bean.CurrencyRequest;
import com.example.demo.bean.CurrencyResponse;
import com.example.demo.model.Salary;
import com.example.demo.model.User;

import java.util.List;

public interface SalaryService {
    Double bynToUsd(Double byn);
    Double bynToEur(Double byn);

    CurrencyResponse allCurrency(CurrencyRequest request);

    Double bynToCny(Double byn);

    Double bynToCnyPost(CurrencyRequest request);



   

    Salary getSalaryById(Integer id);

    Salary addSalary(Salary salary);

    Salary updateSalaryById(Salary salary, Integer id);

    String deleteSalaryById(Integer id);

    List<Salary> findSalaryMoreNumber(Double number);
}
