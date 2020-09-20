package com.zzc.weatherreportserver.service;

import com.zzc.weatherreportserver.entity.City;
import com.zzc.weatherreportserver.vo.WeatherResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author zzc
 * @create 2020-06-10 11:34
 */
@FeignClient("weather-eureka-client")
public interface DataClient {

    /**
     * 获取城市列表
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市id查询天气数据
     *
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponseVO getDataByCityId(@PathVariable("cityId") String cityId);
}