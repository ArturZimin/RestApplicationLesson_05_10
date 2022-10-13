package com.example.demo.controller;

import com.example.demo.bean.CurrencyRequest;
import com.example.demo.bean.CurrencyResponse;
import com.example.demo.model.Salary;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.SalaryService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    private SalaryService salaryService;


    @GetMapping("/salary/eur/get/{salary}")//path variable  http://localhost:8080/salary/usd/get/36000
    public Double salaryToEUR(@PathVariable(name = "salary") Integer salary) {
        if (salary == null) {
            return 0.0;
        }
        return salaryService.bynToEur(Double.valueOf(salary.toString()));
    }

    @PostMapping("/salary/post/cny/")
    public Double salaryToCnyPost(@RequestBody CurrencyRequest request) {

        return salaryService.bynToCnyPost(request);
    }

    @GetMapping("/salary/cny/get/{salary}") //по этому пути вводим вместо salary свою зарплату и переводим в юани
    public Double salaryToCNY(@PathVariable(name = "salary") Double salary) {
        if (salary == null) {
            return 0.0;
        }
        return salaryService.bynToCny(Double.valueOf(salary.toString()));
    }

    @GetMapping("/salary/usd/get/")//path variable   http://localhost:8080/salary/eur/get/%7Bsalary%7D?salary=10000
    public Double salaryToUSD(@RequestParam(name = "salary") Integer salary) {
        if (salary == null) {
            return 0.0;
        }
        return salaryService.bynToUsd(Double.valueOf(salary.toString()));
    }


    @PostMapping("/salary/all/currency/")//тест через постман
    public CurrencyResponse allSalary(@RequestBody CurrencyRequest request) {
        return salaryService.allCurrency(request);
    }

    @PostMapping("/add/salary/")
    public Salary addSalary(@RequestBody Salary salary) {

        return salaryService.addSalary(salary);
    }


    @GetMapping("/get/salary/by/id/{id}")
    public Salary getSalaryById(@PathVariable(name = "id") Integer id) {
        return salaryService.getSalaryById(id);
    }

    @PutMapping("/update/salary/by/id/{id}")
    public Salary updateSalary(@RequestBody Salary salary,@PathVariable(name = "id")Integer id){
        return salaryService.updateSalaryById(salary,id);
    }

    @DeleteMapping("/delete/salary/{id}")
    public  String deleteSalaryById(@PathVariable(name = "id") Integer id){
        return salaryService.deleteSalaryById(id);
    }

@GetMapping("/get/salary/more/{number}")
    public List<Salary> getSalaryMoreNumber(@PathVariable Double number){
        return salaryService.findSalaryMoreNumber(number);
}




}
/**
 * C - create
 * R - read(get)
 * U - update
 * D - delete
 */