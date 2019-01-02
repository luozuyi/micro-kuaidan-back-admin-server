package com.kuaidan.service;

import com.kuaidan.utils.Result;

import java.util.Map;

public interface TalkShowService {
    /**
     * 快蛋说分页条件查询
     * @param pageNum
     * @param pageSize
     * @param params
     * @return
     */
    Result pageList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    /**
     * 快蛋说详情
     * @param id
     * @return
     */
    Result takeShowDetail(String id);

    /**
     * 置顶
     * @param id
     * @return
     */
    Result overhead(String id);

    /**
     * 取消置顶
     * @param id
     * @return
     */
    Result cancelOverhead(String id);

    /**
     * 启用
     * @param id
     * @return
     */
    Result startUsing(String id);

    /**
     * 禁用
     * @param id
     * @return
     */
    Result disabled(String id);

    /**
     * 假删除
     * @param id
     * @return
     */
    Result delFlag(String id);

    /**
     * 批量假删除
     * @param ids
     * @return
     */
    Result delFlagMany(String[] ids);


}
