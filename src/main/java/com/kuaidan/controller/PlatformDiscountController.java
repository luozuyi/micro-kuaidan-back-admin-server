package com.kuaidan.controller;

import com.kuaidan.service.PlatformDiscountService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by xzz on 2018/12/26.
 **/
@RestController
public class PlatformDiscountController {
    @Autowired
    private PlatformDiscountService platformDiscountService;

    /**
     * 查询所有的折扣规则
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "v1/auth/platform-discount/all")
    public Result getList( Integer pageNum, Integer pageSize){
        return platformDiscountService.pageList(pageNum, pageSize);
    }

    /**
     * 新增规则
     * @param map
     * @return
     */
    @PostMapping(value = "v1/auth/platform-discount/insert")
    public Result insertDiscount(@RequestParam Map<String,Object> map){
        return platformDiscountService.insertDiscount(map);
    }

    @GetMapping(value = "v1/auth/platform-discount/getone")
    public Result getone( String id){
        return platformDiscountService.selectById(id);
    }
    /**
     * 编辑规则
     * @param map
     * @return
     */
    @PostMapping(value = "v1/auth/platform-discount/update")
    public Result updateDiscount(@RequestParam Map<String,Object> map){
        return  platformDiscountService.updateDiscount(map);
    }

    /**
     * 假删除规则
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/platform-discount/delete")
    public Result deleteDiscount(String id){
        return platformDiscountService.deleteDiscount(id);
    }
}
