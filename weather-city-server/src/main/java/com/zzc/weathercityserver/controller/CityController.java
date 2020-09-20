package com.zzc.weathercityserver.controller;

import com.zzc.weathercityserver.entity.City;
import com.zzc.weathercityserver.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzc
 * @create 2020-06-08 13:24
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception{
        return cityDataService.listCity();
    }
}
