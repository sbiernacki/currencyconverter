package com.biernat.currencyconverter.config;

import com.biernat.currencyconverter.service.creator.DataSetCreatorService;
import com.biernat.currencyconverter.service.creator.DataSetCreatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestsConfig
{
    @Bean
    public DataSetCreatorService dataSetCreatorService()
    {
        return new DataSetCreatorServiceImpl();
    }
}
