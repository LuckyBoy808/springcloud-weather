package com.zzc.weathercollectionserver.service;

/**
 * @author zzc
 * @create 2020-06-08 12:15
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市ID同步天气数据
     *
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
