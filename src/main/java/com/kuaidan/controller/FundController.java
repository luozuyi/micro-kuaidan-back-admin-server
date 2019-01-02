package com.kuaidan.controller;

import com.kuaidan.entity.Fund;
import com.kuaidan.service.FundService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W1665
 * @date 2018/12/22
 */
@RestController
public class FundController {

    @Autowired
    private FundService fundService;

    /**
     * 多条件筛选资金列表
     * @param fund
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "v1/auth/fund-services")
    public Result getList(Fund fund, Integer pageNum, Integer pageSize){
        return fundService.getFundList(fund, pageNum, pageSize);
    }

    /**
     * 资金详情
     * @param id
     * @return
     */
    @GetMapping(value = "v1/auth/fund-service-details")
    public Result getDetail(String id){
        return fundService.getDetail(id);
    }
}
