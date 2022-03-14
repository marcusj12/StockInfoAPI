package com.careerdevs.StockInfoAPI.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/api/stock")
public class StockController {

    @Autowired
    private Environment env;



    @GetMapping ("/test")
    private String testRoute () {
        return "testing, request received";
    }

    @GetMapping ("/query")
    private String getStocks (@RequestParam String ticker, RestTemplate restTemplate) {
        String url = "https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + ticker + "&apikey=";
        String apiKey = env.getProperty("API_KEY");
        url += apiKey;
        System.out.println(url);
        return restTemplate.getForObject(url,String.class);
    }

}


//https://www.alphavantage.co/query?function=