package com.biernat.repository;

import com.biernat.model.Currency;

public interface CurrencyRepository
{
    Currency getCurrency(String currencyCode);
}
