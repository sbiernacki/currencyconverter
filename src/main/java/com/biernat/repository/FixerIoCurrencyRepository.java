package com.biernat.repository;

import com.biernat.model.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@AllArgsConstructor
public class FixerIoCurrencyRepository implements CurrencyRepository
{
    private RestTemplate restTemplate;
    
    @Override
    public Currency getCurrency(String currencyCode)
    {
        Currency currency = restTemplate.getForObject("http://data.fixer.io/api/latest?access_key=fb33e89a52a110ce062e5f47f9158160&format=1&base={currencyCode}", Currency.class, currencyCode);
        
        return currency;
    }
}
