package com.zzc.weatherreportserver;

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
public class WeatherReportServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WeatherReportServerApplication.class, args);
  }
}
