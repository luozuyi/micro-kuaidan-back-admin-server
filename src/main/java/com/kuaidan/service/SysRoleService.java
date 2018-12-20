package com.kuaidan.service;

import com.kuaidan.entity.SysRole;
import com.kuaidan.utils.Result;

public interface SysRoleService extends BaseService<SysRole,String>{
    /**
     *
     * @param roleName 角色名称
     * @param sequence 排序
     * @param sysResIds 资源ids
     * @return
     */
    Result add(String roleName, String sequence, String[] sysResIds);

    /**
     * 主键查询角色 以及拥有的权限
     * @param roleId 角色id
     * @return
     */
    Result findById(String roleId);

    /**
     * 修改角色名称，排序，以及权限
     * @param roleId 主键id
     * @param roleName 要修改的名称
     * @param sequence 要修改后的排序
     * @param sysResIds 要修改后的权限数组
     * @return
     */
    Result update(String roleId, String roleName, String sequence, String[] sysResIds);

    /**
     * 分页查询角色列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    Result pageList(Integer pageNum, Integer pageSize);

    /**
     * 查询列表
     * @return
     */
    Result list();
}
