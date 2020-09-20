package com.zzc.weathercollectionserver.service.impl;

import com.zzc.weathercollectionserver.constant.RedisConstant;
import com.zzc.weathercollectionserver.constant.StatusCodeConstant;
import com.zzc.weathercollectionserver.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author zzc
 * @create 2020-06-08 12:16
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URL + "citykey=" + cityId;
        saveWeatherData(uri);
    }

    /**
     * 把天气数据保存到缓存中
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        if (StatusCodeConstant.OK == responseEntity.getStatusCodeValue()) {
            strBody = responseEntity.getBody();
        }
        ops.set(key, strBody, RedisConstant.TIME_OUT, TimeUnit.SECONDS);
    }
}
