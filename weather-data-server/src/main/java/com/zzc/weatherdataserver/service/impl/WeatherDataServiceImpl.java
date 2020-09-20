package com.zzc.weatherdataserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzc.weatherdataserver.service.WeatherDataService;
import com.zzc.weatherdataserver.vo.WeatherResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author zzc
 * @create 2020-05-30 20:52
 */
@Service
@Slf4j
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponseVO getDataByCityId(String cityId) {
        String uri = WEATHER_URL + "citykey=" + cityId;

        return doGetWeather(uri, WeatherResponseVO.class);
    }

    @Override
    public WeatherResponseVO getDataByCityName(String cityName) {
        String uri = WEATHER_URL + "city=" + cityName;

        return doGetWeather(uri, WeatherResponseVO.class);
    }

    private <T> T doGetWeather(String uri, Class<T> type) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        // 先查询缓存，如果缓存有，则从缓存中取
        if (stringRedisTemplate.hasKey(key)) {
            log.info("Redis has data");
            strBody = ops.get(key);
        } else {
            log.info("Redis don't has data");
            // 如果缓存没有，则抛出异常
            throw new RuntimeException("Don't has data");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            t = objectMapper.readValue(strBody, type);
        } catch (Exception e) {
            log.error("Error!", e);
        }
        return t;
    }
}