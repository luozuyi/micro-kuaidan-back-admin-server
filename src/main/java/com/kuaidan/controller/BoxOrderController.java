package com.kuaidan.controller;

import com.kuaidan.entity.BoxOrder;
import com.kuaidan.service.BoxOrderService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author W1665
 * @date 2018/12/22
 */
@RestController
public class BoxOrderController {

    @Autowired
    private BoxOrderService boxOrderService;

    /**
     * 多条件筛选盒子订单
     * @param boxOrder
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "v1/auth/box-orders")
    public Result getList(BoxOrder boxOrder, Integer pageNum, Integer pageSize){
        return boxOrderService.getBoxOrderList(boxOrder, pageNum, pageSize);
    }

    /**
     * 确认发货
     * @param id
     * @param name
     * @param sendTime
     * @param expressCompany
     * @param expressNumber
     * @return
     */
    @PatchMapping(value = "v1/auth/box-orders")
    public Result update(String id,String name,String sendTime,String expressCompany,String expressNumber){
        return boxOrderService.updateBoxOrder(id, name, sendTime, expressCompany, expressNumber);
    }

    /**
     * 获取订单盒子详情
     * @param id
     * @return
     */
    @GetMapping(value = "v1/auth/box-order-details")
    public Result getDetail(String id){
        return boxOrderService.getDetail(id);
    }

    /**
     *后台确认收货
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/box-order-sure")
    public Result sure(String id){
        return boxOrderService.sureReceive(id);
    }
}
