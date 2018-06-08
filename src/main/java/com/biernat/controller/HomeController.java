package com.biernat.controller;

import com.biernat.model.ConversionData;
import com.biernat.model.DataSet;
import com.biernat.model.SupportedCurrencies;
import com.biernat.service.converter.CurrencyConverterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController
{
    private CurrencyConverterService currencyConverterService;
    
    @GetMapping({"/", "/home"})
    public String home(Model model)
    {
        model.addAttribute("conversionData", new ConversionData());
        model.addAttribute("supportedCurrencies", SupportedCurrencies.getCurrencyCodes());
    
        return "home";
    }
    
    @PostMapping({"/", "/home"})
    public String homeSubmit()
    {
        return "redirect:/result";
    }
    
    @GetMapping("/result")
    public String result(@ModelAttribute("conversionData") ConversionData conversionData,
        Model model)
    {
        DataSet dataSet = currencyConverterService.convert(conversionData);
        model.addAttribute("dataSet", dataSet);
        
        return "result";
    }
    
    @GetMapping("/about")
    public String about()
    {
        return "about";
    }
}