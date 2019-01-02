package com.kuaidan.service;

import com.kuaidan.entity.Fund;
import com.kuaidan.utils.Result;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author W1665
 * @date 2018/12/22
 */
public interface FundService {

    /**
     * 多条件筛选资金列表
     * @param fund
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result getFundList(Fund fund, Integer pageNum, Integer pageSize);

    /**
     * 资金详情
     * @param id
     * @return
     */
    Result getDetail(String id);
}
