package com.example.demo.service.impl;

import com.example.demo.bean.CurrencyRequest;
import com.example.demo.bean.CurrencyResponse;
import com.example.demo.model.Salary;
import com.example.demo.model.User;
import com.example.demo.repository.SalaryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SalaryService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  SalaryRepository salaryRepository;

    @Override
    public Double bynToUsd(Double byn) {
        return byn / 2.5;
    }

    @Override
    public Double bynToEur(Double byn) {
        return byn / 2.4;
    }

    @Override
    public CurrencyResponse allCurrency(CurrencyRequest request) {
        CurrencyResponse response = new CurrencyResponse();
        response.setEur(bynToEur(request.getSalary()));
        response.setUsd(bynToUsd(request.getSalary()));
        response.setUsd(bynToCny(request.getSalary()));

        return response;
    }

    @Override
    public Double bynToCny(Double byn) {
        return byn * 2.8047;
    }


    @Override
    public Double bynToCnyPost(CurrencyRequest request) {
        CurrencyResponse response = new CurrencyResponse();
        response.setCny(bynToCny(request.getSalary()));
        return response.getCny();
    }



    @Override
    public Salary getSalaryById(Integer id) {
        return salaryRepository.findById(id).get();
    }

    @Override
    public Salary addSalary(Salary salary) {
        return salaryRepository.findById(salary.getId()).get();
    }

    @Override
    public Salary updateSalaryById(Salary salary, Integer id) {
        Salary s=salaryRepository.findById(id).get();
        s.setValue(salary.getValue());
        return salaryRepository.save(s);
    }

    @Override
    public String deleteSalaryById(Integer id) {
      Salary salary=  salaryRepository.findById(id).get();
      if (!salary.equals(Optional.empty()) ){
          salaryRepository.delete(salary);
          return "Ok"+salary.toString();
      }else {
       return "Not ok salary not found!";
      }

      
    }

    @Override
    public List<Salary> findSalaryMoreNumber(Double number) {
        List<Salary> listSalaryMoreNumber=salaryRepository.findByValueGreaterThan(number);
        return listSalaryMoreNumber;
    }


}
