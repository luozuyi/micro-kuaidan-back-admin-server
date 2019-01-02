package com.kuaidan.controller;

import com.kuaidan.service.StatisticsDataService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by W1665 on 2018/12/28.
 */
@RestController
public class StatisticsDataController {

    @Autowired
    private StatisticsDataService statisticsDataService;

    /**
     * 首页统计数据
     * @return
     */
    @GetMapping(value = "v1/auth/statistics-datas")
    public Result getData(){
        return statisticsDataService.getData();
    }
}
