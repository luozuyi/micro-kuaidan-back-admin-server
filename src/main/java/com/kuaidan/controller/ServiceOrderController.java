package com.kuaidan.controller;

import com.kuaidan.entity.ServiceOrder;
import com.kuaidan.service.ServiceOrderService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W1665
 * @date 2018/12/21
 */
@RestController
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    /**
     * 多条件筛选获取订单
     * @param serviceOrder
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "v1/auth/service-orders")
    public Result getListSelection(ServiceOrder serviceOrder, Integer pageNum, Integer pageSize){
        return  serviceOrderService.getServiceOrderSelection(serviceOrder, pageNum, pageSize);
    }


    /**
     * 获取服务订单id
     * @param id
     * @return
     */
    @GetMapping(value = "v1/auth/service-order-details")
    public Result getDetail(String id){
        return serviceOrderService.getDetail(id);
    }
}
