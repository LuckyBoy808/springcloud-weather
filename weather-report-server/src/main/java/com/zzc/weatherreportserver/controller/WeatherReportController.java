package com.zzc.weatherreportserver.controller;

import com.zzc.weatherreportserver.entity.City;
import com.zzc.weatherreportserver.service.DataClient;
import com.zzc.weatherreportserver.service.WeatherReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zzc
 * @create 2020-05-31 10:16
 */
@RestController
@RequestMapping("/report")
@Slf4j
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        // 改为由城市数据API微服务提供数据
        List<City> cityList = null;
        try {
            cityList = dataClient.listCity();
        } catch (Exception e) {
            log.error("Exception!", e);
        }
        model.addAttribute("title", "小朱的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}