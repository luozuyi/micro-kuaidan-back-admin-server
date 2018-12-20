package com.kuaidan.controller;

import com.kuaidan.service.AdminService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * 添加管理员
     * @param adminName 管理员名称
     * @param password 管理员密码
     * @param roleId 管理员角色id
     * @param isDelFlag 是否禁用0：否，1：是
     * @param surePassword 确认密码
     * @return
     */
    @PostMapping(value = "v1/auth/admins")
    public Result addAdmin(String adminName,String qq, String password, String roleId, String isDelFlag, String surePassword) {
        return adminService.addAdmin(adminName,qq,password, roleId, isDelFlag, surePassword);
    }
    /**
     * 分页查询管理员列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @GetMapping(value = "v1/auth/admins/pagination")
    public Result pageList(Integer pageNum, Integer pageSize) {
        return adminService.pageList(pageNum, pageSize);
    }

    /**
     * 查询管理员详情以及角色
     * @param adminId 主键id
     * @return
     */
    @GetMapping(value = "v1/auth/admins/id")
    public Result findById(String adminId) {
        return adminService.findById(adminId);
    }

    /**
     * 修改管理员以及角色
     * @param adminId 管理员id
     * @param password 密码
     * @param roleId 要修改的角色id
     * @param isDisable 是否禁用
     * @param surePassword 确认密码
     * @return
     */
    @PatchMapping(value = "v1/auth/admins")
    public Result update(String adminId, String password, String roleId, String isDisable, String surePassword,@CookieValue String kuaidanAdminToken) {
        return adminService.update(adminId, password, roleId, isDisable, surePassword,kuaidanAdminToken);
    }

    /**
     * 启用
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/admins/update-del/id")
    public Result updateDel(String id){
        return adminService.updateDel(id);
    }

    /**
     * 禁用
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/admins/del-flag/id")
    public Result delFlag(String id){
        return adminService.delFlag(id);
    }

    /**
     * 删除管理员
     * @param id
     * @return
     */
    @DeleteMapping(value = "v1/auth/admins/id")
    public Result delete(String id){
        return adminService.delete(id);
    }

    /**
     * 修改头像
     * @param id 主键id
     * @param imagePath 头像地址
     * @return
     */
    @PatchMapping(value = "v1/auth/admins/id/image-path")
    public Result updateImage(String id,String imagePath) {
        return adminService.updateImage(id,imagePath);
    }

    /**
     * 修改电话
     * @param id 主键id
     * @param telephone 电话
     * @return
     */
    @PatchMapping(value = "v1/auth/admins/id/telephone")
    public Result updateTelephone(String id,String telephone) {
        return adminService.updateTelephone(id,telephone);
    }

    /**
     * 修改qq
     * @param id 主键id
     * @param qq qq号
     * @return
     */
    @PatchMapping(value = "v1/auth/admins/id/qq")
    public Result updateQq(String id,String qq) {
        return adminService.updateQq(id,qq);
    }
}
