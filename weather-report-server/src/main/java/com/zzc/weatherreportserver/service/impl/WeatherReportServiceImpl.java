package com.zzc.weatherreportserver.service.impl;

import com.zzc.weatherreportserver.service.DataClient;
import com.zzc.weatherreportserver.service.WeatherReportService;
import com.zzc.weatherreportserver.vo.WeatherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zzc
 * @create 2020-06-01 16:09
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public WeatherVO getDataByCityId(String cityId) {
        // 改为由天气数据API微服务来提供数据

        return dataClient.getDataByCityId(cityId).getData();
    }
}
