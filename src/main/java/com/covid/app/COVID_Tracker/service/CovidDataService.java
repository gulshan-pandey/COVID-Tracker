package com.covid.app.COVID_Tracker.service;
import com.covid.app.COVID_Tracker.utility.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@Service        //could be @Component as well
public class CovidDataService {         // responsible fot business logic, fetching data from api

    @Autowired
    RestTemplate restTemplate;          // It's used to make HTTP requests to RESTful services and return the response.

    public String getCovidData(String cityname){

        Map<String,Object> map = restTemplate.getForObject(Util.URL, Map.class);
        Map<String, Object> data = (Map<String, Object>) map.get("data");
        ArrayList<Map<String, Object>> statewise = (ArrayList)data.get("statewise");

        for(Map<String,Object> mapp : statewise){

            if (mapp.get("state").toString().equalsIgnoreCase(cityname)) {

               

                String result = mapp.get("confirmed").toString() +","+  
                            mapp.get("recovered").toString() +","+
                            mapp.get("deaths").toString();
                
                return result;
               
            }
        }




        return null;
    }

}
