package com.zzc.weathercollectionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zzc
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WeatherCollectionServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherCollectionServerApplication.class, args);
  }
}
