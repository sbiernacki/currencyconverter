package com.biernat.currencyconverter.repository;

import com.biernat.currencyconverter.model.Currency;

public interface CurrencyRepository
{
    Currency getCurrency(String currencyCode);
}
