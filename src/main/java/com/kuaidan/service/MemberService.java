package com.kuaidan.service;

import com.kuaidan.entity.Member;
import com.kuaidan.utils.Result;

import java.util.Map;

public interface MemberService extends BaseService<Member,String>{
    /**
     * 详情
     * @param id 主键id
     * @return
     */
    Result detail(String id);

    /**
     * 分页查询会员
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params 参数
     * @return
     */
    Result pageListByParams(Integer pageNum, Integer pageSize, Map<String,Object> params);
}
