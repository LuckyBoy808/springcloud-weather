package com.zzc.weathercityserver.service;

import com.zzc.weathercityserver.entity.City;

import java.util.List;

/**
 * @author zzc
 * @create 2020-06-01 15:12
 */
public interface CityDataService {
    /**
     * 获取城市列表
     *
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
