package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyResponse {

    private Double usd;
    private Double eur;
    private Double cny;//юань
    private Double chf;//швейцарский франк
}

