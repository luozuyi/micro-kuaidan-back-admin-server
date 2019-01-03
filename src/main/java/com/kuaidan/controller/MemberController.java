package com.kuaidan.controller;

import com.kuaidan.service.MemberService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    /**
     * 查询详情
     * @param id 主键id
     * @return
     */
    @GetMapping(value = "v1/auth/members/id")
    public Result detail(String id) {
        return memberService.detail(id);
    }

    /**
     * 分页查询会员
     * @param pageNum 当前页
     * @param pageSize 一页显示多少条
     * @param params 参数map
     * @return
     */
    @GetMapping(value = "v1/auth/members/pagination")
    public Result pageListByParams(Integer pageNum, Integer pageSize, @RequestParam Map<String, Object> params) {
        return memberService.pageListByParams(pageNum,pageSize,params);
    }
}