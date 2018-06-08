package com.biernat.service.converter;

import com.biernat.model.ConversionData;
import com.biernat.model.DataSet;

public interface CurrencyConverterService
{
    DataSet convert(ConversionData conversionData);
}
