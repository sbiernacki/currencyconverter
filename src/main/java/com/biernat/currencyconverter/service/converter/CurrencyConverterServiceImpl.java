package com.biernat.currencyconverter.service.converter;

import com.biernat.currencyconverter.model.ConversionData;
import com.biernat.currencyconverter.model.Currency;
import com.biernat.currencyconverter.model.DataSet;
import com.biernat.currencyconverter.repository.CurrencyRepository;
import com.biernat.currencyconverter.service.creator.DataSetCreatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrencyConverterServiceImpl implements CurrencyConverterService
{
    private CurrencyRepository currencyRepository;
    private DataSetCreatorService dataSetCreatorService;
    
    public DataSet convert(ConversionData conversionData)
    {
        Currency baseCurrency = currencyRepository.getCurrency(conversionData.getBaseCurrencyCode());
        String[] targetCurrencyCodes = conversionData.getTargetCurrencyCodes();
        double amount = conversionData.getAmount();
        
        return dataSetCreatorService.create(baseCurrency, targetCurrencyCodes, amount);
    }
}