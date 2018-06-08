package com.biernat.currencyconverter.service.creator;

import com.biernat.currencyconverter.model.Currency;
import com.biernat.currencyconverter.model.DataSet;

public interface DataSetCreatorService
{
    DataSet create(Currency currency, String[] targetCurrencyCodes, double amount);
}
