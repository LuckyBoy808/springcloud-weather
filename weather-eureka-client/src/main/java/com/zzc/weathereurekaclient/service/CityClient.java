package com.zzc.weathereurekaclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zzc
 * @create 2020-06-10 10:50
 */
@FeignClient("weather-city-server")
public interface CityClient {

    /**
     * 获取城市列表
     *
     * @return
     */
    @GetMapping("/cities")
    String listCity();
}