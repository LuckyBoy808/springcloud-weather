package com.zzc.weathercollectionserver.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

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
