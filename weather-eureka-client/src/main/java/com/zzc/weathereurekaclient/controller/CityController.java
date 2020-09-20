package com.zzc.weathereurekaclient.controller;

import com.zzc.weathereurekaclient.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzc
 * @create 2020-06-10 10:54
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public String listCity() {
        return cityClient.listCity();
    }
}
