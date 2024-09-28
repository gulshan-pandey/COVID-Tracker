package com.covid.app.COVID_Tracker.controller;


import com.covid.app.COVID_Tracker.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller is not for Buisness logic, controller is an representational perpose


@RestController
@RequestMapping("/covid-data")
public class CovidController {

    @Autowired
    CovidDataService covidDataService;




    //  localhost:8080//covid-data/citywise/delhi
    @CrossOrigin(origins = "http://127.0.0.1:3000")    // Allow this specific frontend origin
    @GetMapping("/citywise/{state}")
    public String getCovidCases(@PathVariable String state) {

        System.out.println(state);
       return  covidDataService.getCovidData(state)== null ? null : covidDataService.getCovidData(state);


    }


}
