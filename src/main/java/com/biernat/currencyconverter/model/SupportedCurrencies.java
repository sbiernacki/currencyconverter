package com.biernat.currencyconverter.model;

public enum SupportedCurrencies
{
    EUR, PLN, USD, GBP;
    
    public static String[] getCurrencyCodes()
    {
        SupportedCurrencies[] supportedCurrencies = SupportedCurrencies.values();
        String[] currencyCodes = new String[supportedCurrencies.length];
        for(int i = 0; i < supportedCurrencies.length; i++)
        {
            currencyCodes[i] = supportedCurrencies[i].toString();
            
        }
        return currencyCodes;
    }
}
