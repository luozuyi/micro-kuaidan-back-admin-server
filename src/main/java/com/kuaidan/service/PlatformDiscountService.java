package com.kuaidan.service;

import com.kuaidan.utils.Result;

import java.util.Map;

/**
 * Created by xzz on 2018/12/25.
 **/
public interface PlatformDiscountService {

    /**
     * 查询所有折扣规则
     * @return
     */
    Result pageList(Integer pageNum, Integer pageSize);

    /**
     * 添加规则
     * @param map
     * @return
     */
    Result insertDiscount(Map<String,Object> map);

    /**
     * 编辑规则
     * @param map
     * @return
     */
    Result updateDiscount(Map<String, Object> map);

    /**
     * 假删除规则
     * @param id
     * @return
     */
    Result deleteDiscount(String id);

    /**
     * 查询一个折扣规则详情
     * @param id
     * @return
     */
    Result selectById(String id);
}
