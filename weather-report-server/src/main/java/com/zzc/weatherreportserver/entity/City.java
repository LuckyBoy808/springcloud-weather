package com.zzc.weatherreportserver.entity;

import lombok.Data;

/**
 * @author zzc
 * @create 2020-06-01 14:58
 */
@Data
public class City {
    private String cityId;
    private String cityName;
    private String cityCode;
    private String province;
}
