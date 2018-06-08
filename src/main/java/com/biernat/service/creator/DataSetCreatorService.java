package com.biernat.service.creator;

import com.biernat.model.Currency;
import com.biernat.model.DataSet;

public interface DataSetCreatorService
{
    DataSet create(Currency currency, String[] targetCurrencyCodes, double amount);
}
