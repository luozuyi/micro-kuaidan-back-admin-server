package com.kuaidan.service;

import com.kuaidan.entity.Admin;
import com.kuaidan.utils.Result;

public interface AdminService extends BaseService<Admin,String>{
    /**
     * 添加管理员
     * @param adminName 管理员名称
     * @param password 管理员密码
     * @param roleId 管理员角色id
     * @param isDelFlag 是否禁用0：否，1：是
     * @param surePassword 确认密码
     * @return
     */
    Result addAdmin(String adminName, String qq, String password, String roleId, String isDelFlag, String surePassword);

    /**
     * 详情
     * @param adminId 主键id
     * @return
     */
    Result findById(String adminId);

    /**
     * 修改管理员信息
     * @param adminId 管理员id
     * @param password 管理员密码
     * @param roleId 角色id
     * @param isDelFlag 是否禁用
     * @param surePassword 确认密码
     * @return
     */
    Result update(String adminId, String password, String roleId, String isDelFlag, String surePassword,String token);

    /**
     * 启用
     * @param id  主键id
     * @return
     */
    Result updateDel(String id);

    /**
     * 禁用
     * @param id
     * @return
     */
    Result delFlag(String id);

    /**
     * 删除管理员
     * @param id  主键id
     * @return
     */
    Result delete(String id);

    /**
     * 修改头像
     * @param imagePath 头像地址
     * @return
     */
    Result updateImage(String id,String imagePath);

    /**
     * 修改电话
     * @param id 主键id
     * @param telephone 电话
     * @return
     */
    Result updateTelephone(String id,String telephone);

    /**
     * 修改qq
     * @param id 主键id
     * @param qq qq
     * @return
     */
    Result updateQq(String id,String qq);
}
