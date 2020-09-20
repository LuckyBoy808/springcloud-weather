package com.zzc.weathercollectionserver.job;

import com.zzc.weathercollectionserver.entity.City;
import com.zzc.weathercollectionserver.service.CityClient;
import com.zzc.weathercollectionserver.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzc
 * @create 2020-06-01 13:15
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Weather Data Sync Job. Start!");
        // 获取城市ID列表
        // 改为由城市数据API微服务提供数据
        List<City> cityList = null;
        try {
            cityList = cityClient.listCity();
        } catch (Exception e) {
            log.error("Exception!", e);
        }

        // 遍历城市ID，获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityId:" + cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }
        log.info("Weather Data Sync Job. End!");
    }
}
