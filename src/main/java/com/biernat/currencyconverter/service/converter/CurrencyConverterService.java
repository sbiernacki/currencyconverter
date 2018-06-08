package com.biernat.currencyconverter.service.converter;

import com.biernat.currencyconverter.model.ConversionData;
import com.biernat.currencyconverter.model.DataSet;

public interface CurrencyConverterService
{
    DataSet convert(ConversionData conversionData);
}
