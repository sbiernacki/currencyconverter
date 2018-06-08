package com.biernat.currencyconverter.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HomeControllerTest
{
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private WebClient webClient;
    
    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        this.webClient = MockMvcWebClientBuilder.webAppContextSetup(wac).build();
    }
    
    @After
    public void close()
    {
        this.webClient.close();
    }
    
    @Test
    public void getHomePageTest() throws Exception
    {
        shouldReturnHomeView("/");
        shouldReturnHomeView("/home");
    }
    
    private void shouldReturnHomeView(String uri) throws Exception
    {
        this.mockMvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"))
                    .andExpect(model().attributeExists("conversionData", "supportedCurrencies"))
                    .andExpect(model().attribute("conversionData", hasProperty("baseCurrencyCode", Matchers.is("EUR"))))
                    .andExpect(model().attribute("conversionData", hasProperty("amount", Matchers.is(1.0))));
    }
    
    @Test
    public void shouldRedirectToResultView() throws Exception
    {
        this.mockMvc.perform(post("/")
                                 .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                 .param("baseCurrencyCode", "EUR")
                                 .param("amount", "1.0")
                                 .param("targetCurrencyCodes", "EUR")
                                 .param("targetCurrencyCodes", "PLN")
                                 .param("targetCurrencyCodes", "USD")
                                 .param("targetCurrencyCodes", "GBP"))
                    .andDo(print())
                    .andExpect(status().isFound())
                    .andExpect(redirectedUrl("/result"));
    }
}
