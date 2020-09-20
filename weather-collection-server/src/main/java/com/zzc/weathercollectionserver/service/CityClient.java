package com.zzc.weathercollectionserver.service;

import com.zzc.weathercollectionserver.entity.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zzc
 * @create 2020-06-10 11:34
 */
@FeignClient("weather-city-server")
public interface CityClient {

    /**
     * 获取城市列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}