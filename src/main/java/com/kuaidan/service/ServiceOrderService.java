package com.kuaidan.service;
import com.kuaidan.entity.ServiceOrder;
import com.kuaidan.utils.Result;

/**
 *
 * @author W1665
 * @date 2018/12/21
 */
public interface ServiceOrderService {

    /**
     * 多条件筛选服务订单
     * @param serviceOrder
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result getServiceOrderSelection(ServiceOrder serviceOrder,Integer pageNum,Integer pageSize);


    /**
     * 服务订单id
     * @param id
     * @return
     */
    Result getDetail(String id);
}
