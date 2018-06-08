package com.biernat.service.converter;

import com.biernat.model.ConversionData;
import com.biernat.model.Currency;
import com.biernat.model.DataSet;
import com.biernat.repository.CurrencyRepository;
import com.biernat.service.creator.DataSetCreatorService;
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