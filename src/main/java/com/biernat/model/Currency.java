package com.biernat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Currency
{
    private String base;
    private String date;
    private Map<String, Double> rates = new HashMap<>();
    
    public void setRate(String currencyCode, double rate)
    {
        this.rates.put(currencyCode, rate);
    }
    
    public double getRate(String currencyCode)
    {
        return this.rates.get(currencyCode);
    }
}
