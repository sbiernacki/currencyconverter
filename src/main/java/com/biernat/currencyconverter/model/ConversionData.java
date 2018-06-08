package com.biernat.currencyconverter.model;

import lombok.Data;

@Data
public class ConversionData
{
    private String baseCurrencyCode = "EUR";
    private double amount = 1;
    private String[] targetCurrencyCodes;
}
