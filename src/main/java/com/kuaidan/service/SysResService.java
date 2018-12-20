package com.kuaidan.service;

import com.kuaidan.entity.SysRes;
import com.kuaidan.utils.Result;

public interface SysResService extends BaseService<SysRes,String>{
    /**
     * 添加权限
     * @param sysRes 权限对象
     * @return
     */
    Result add(SysRes sysRes);

    /**
     * 修改
     * @param sysRes 权限对象
     * @return
     */
    Result update(SysRes sysRes);

    /**
     * 查询列表
     * @return
     */
    Result getList();

    /**
     * 主键假删除权限
     * @param id 主键id
     * @return
     */
    Result updateDelFlag(String id);
}
