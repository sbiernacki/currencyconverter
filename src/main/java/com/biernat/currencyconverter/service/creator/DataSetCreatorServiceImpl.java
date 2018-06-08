package com.biernat.currencyconverter.service.creator;

import com.biernat.currencyconverter.model.Currency;
import com.biernat.currencyconverter.model.DataSet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataSetCreatorServiceImpl implements DataSetCreatorService
{
    
    @Override
    public DataSet create(Currency currency, String[] targetCurrencyCodes, double amount)
    {
        String baseCurrencyCode = currency.getBase().toUpperCase();
        Map<String, Double> rates = new HashMap<>();
        
        for(String currencyCode : targetCurrencyCodes)
        {
            Double rate = 0.0;
            if(currencyCode.equals(baseCurrencyCode))
            {
                rate = 1.0 * amount;
            }
            else
            {
                rate = currency.getRate(currencyCode) * amount;
            }
            rates.put(currencyCode, rate);
        }
        return new DataSet(baseCurrencyCode, amount, rates);
    }
}
