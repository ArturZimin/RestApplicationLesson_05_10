package com.example.demo.service;

import com.example.demo.bean.CurrencyRequest;
import com.example.demo.bean.CurrencyResponse;

public interface SalaryService {
    Double bynToUsd(Double byn);
    Double bynToEur(Double byn);

    CurrencyResponse allCurrency(CurrencyRequest request);
}
