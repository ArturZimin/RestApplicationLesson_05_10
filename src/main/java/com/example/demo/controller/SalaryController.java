package com.example.demo.controller;

import com.example.demo.bean.CurrencyRequest;
import com.example.demo.bean.CurrencyResponse;
import com.example.demo.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalaryController {

    @Autowired
    private SalaryService salaryService;


    @GetMapping("/salary/eur/get/{salary}")//path variable  http://localhost:8080/salary/usd/get/36000
    public Double salaryToEUR(@PathVariable(name="salary") Integer salary){
        if (salary==null){
            return 0.0;
        }
        return salaryService.bynToEur(Double.valueOf(salary.toString()));
    }

    @GetMapping("/salary/usd/get/")//path variable   http://localhost:8080/salary/eur/get/%7Bsalary%7D?salary=10000
    public Double salaryToUSD(@RequestParam(name="salary") Integer salary){
        if (salary==null){
            return 0.0;
        }
        return salaryService.bynToUsd(Double.valueOf(salary.toString()));
    }


    @PostMapping("/salary/all/currency/")//тест через постман
    public CurrencyResponse allSalary(@RequestBody CurrencyRequest request){
        return salaryService.allCurrency(request);
    }



//    @GetMapping("/salary/get/")//path variable
//    public Double salaryToEUR(@RequestParam(name="salary") Integer salary){
//        if (salary==null){
//            return 0.0;
//        }
//        return salaryService.bynToEur(Double.valueOf(salary.toString()));
//    }
}
