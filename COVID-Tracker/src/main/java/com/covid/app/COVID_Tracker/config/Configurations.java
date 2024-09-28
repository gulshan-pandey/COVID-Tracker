package com.covid.app.COVID_Tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration              // use to activate the IOC container
public class Configurations {


    @Bean
    public RestTemplate getInstance(){
        return new RestTemplate();
    }


}
