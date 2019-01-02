package com.kuaidan.service;

import com.kuaidan.entity.BoxOrder;
import com.kuaidan.utils.Result;

/**
 *
 * @author W1665
 * @date 2018/12/21
 */
public interface BoxOrderService {

    /**
     * 多条件筛选盒子订单
     * @param boxOrder
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result getBoxOrderList(BoxOrder boxOrder, Integer pageNum, Integer pageSize);


    /**
     * 确认发货
     * @param id
     * @return
     */
    Result updateBoxOrder(String id,String name,String sendTime,String expressCompany,String expressNumber);


    /**
     * 获取盒子订单详情
     * @param id
     * @return
     */
    Result getDetail(String id);

    /**
     * 确认收货
     * @param id
     * @return
     */
    Result sureReceive(String id);
}
