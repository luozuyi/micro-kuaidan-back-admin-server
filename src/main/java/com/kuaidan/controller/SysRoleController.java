package com.kuaidan.controller;

import com.kuaidan.service.SysRoleService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 添加角色
     * @param roleName 角色名称
     * @param sequence 序号
     * @param sysResIds 权限id数组
     * @return
     */
    @PostMapping(value = "v1/auth/sys-roles")
    public Result add(String roleName, String sequence, @RequestParam(value = "sysResIds[]") String[] sysResIds) {
        return sysRoleService.add(roleName, sequence, sysResIds);
    }

    /**
     * 查询角色详情和拥有的权限
     * @param roleId 角色id
     * @return
     */
    @GetMapping(value = "v1/auth/sys-roles/id")
    public Result findById(String roleId) {
        return sysRoleService.findById(roleId);
    }

    /**
     * 修改角色以及角色权限
     * @param roleId 主键id
     * @param roleName 要修改的名称
     * @param sequence 要修改后的排序
     * @param sysResIds 要修改后的权限数组
     * @return
     */
    @PatchMapping(value = "v1/auth/sys-roles")
    public Result update(String roleId, String roleName, String sequence, @RequestParam(value = "sysResIds[]") String[] sysResIds) {
        return sysRoleService.update(roleId, roleName, sequence, sysResIds);
    }

    /**
     * 分页查询角色列表
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @return
     */
    @GetMapping(value = "v1/auth/sys-roles/pagination")
    public Result pageList(Integer pageNum, Integer pageSize) {
        return sysRoleService.pageList(pageNum, pageSize);
    }

    /**
     * 查询所有角色列表
     * @return
     */
    @GetMapping(value = "v1/auth/sys-roles")
    public Result list() {
        return sysRoleService.list();
    }
}
