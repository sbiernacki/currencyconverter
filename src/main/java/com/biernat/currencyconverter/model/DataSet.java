package com.biernat.currencyconverter.model;

import lombok.Data;

import java.util.Map;

@Data
public class DataSet
{
    private String baseCurrencyCode;
    private double amount;
    private Map<String, Double> rates;
    
    public DataSet(String baseCurrencyCode, double amount, Map<String, Double> rates)
    {
        this.baseCurrencyCode = baseCurrencyCode;
        this.amount = amount;
        this.rates = rates;
    }
}
