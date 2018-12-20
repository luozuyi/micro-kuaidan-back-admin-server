package com.kuaidan.controller;

import com.kuaidan.entity.SysRes;
import com.kuaidan.service.SysResService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysResController {
    @Autowired
    private SysResService sysResService;

    /**
     * 添加权限
     * @param sysRes 权限对象
     * @return
     */
    @PostMapping(value = "v1/auth/sys-ress")
    public Result add(SysRes sysRes) {
        return sysResService.add(sysRes);
    }

    /**
     * 主键id查询
     * @param sysResId 主键ID
     * @return
     */
    @GetMapping(value = "v1/auth/sys-ress/id")
    public Result findById(String sysResId) {
        return sysResService.selectByPrimaryKey(sysResId);
    }

    /**
     * 修改权限
     * @param sysRes 权限对象
     * @return
     */
    @PutMapping(value = "v1/auth/sys-ress")
    public Result update(SysRes sysRes) {
        return sysResService.update(sysRes);
    }

    /**
     * 查询列表
     * @return
     */
    @GetMapping(value = "v1/auth/sys-ress")
    public Result getList() {
        return sysResService.getList();
    }

    /**
     * 主键假删除权限
     * @param id 主键id
     * @return
     */
    @DeleteMapping(value = "v1/auth/sys-ress")
    public Result updateDelFlag(String id) {
        return sysResService.updateDelFlag(id);
    }
}
