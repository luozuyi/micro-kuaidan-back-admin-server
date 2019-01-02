package com.kuaidan.controller;

import com.kuaidan.service.TalkShowService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TalkShowController {

    @Autowired
    private TalkShowService talkShowService;

    /**
     * 快蛋说分页条件查询
     * @param pageNum    当前页
     * @param pageSize   一页显示多少条
     * @param params     参数
     * @return
     */
    @GetMapping(value = "v1/auth/take-show/paginations")
    public Result pageList(Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return talkShowService.pageList(pageNum,pageSize,params);
    }

    /**
     * 快蛋说详情
     * @param id
     * @return
     */
    @GetMapping(value = "v1/auth/take-show/id")
    public Result detail(String id){
        return talkShowService.takeShowDetail(id);
    }

    /**
     * 置顶
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/take-show/overhead")
    public Result overhead(String id){
        return talkShowService.overhead(id);
    }


    /**
     * 取消置顶
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/take-show/cancelOverhead")
    public Result cancelOverhead(String id){
        return talkShowService.cancelOverhead(id);
    }

    /**
     * 启用
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/take-show/startUsing")
    public Result startsing(String id){
        return talkShowService.startUsing(id);
    }

    /**U
     * 禁用
     * @param id
     * @return
     */

    @PatchMapping(value = "v1/auth/take-show/disabled")
    public Result disabled(String id){
        return talkShowService.disabled(id);
    }

    /**
     * 假删除
     * @param id
     * @return
     */
    @PatchMapping(value = "v1/auth/take-show/delFlag")
    public Result delFlag(String id){
        return talkShowService.delFlag(id);
    }

    /**
     * 批量假删除
     * @param ids
     * @return
     */
    @PatchMapping(value = "v1/auth/take-show/delFlagMany")
    public Result delFlagMany(@RequestParam(value = "ids") String[] ids){
        return talkShowService.delFlagMany(ids);
    }


}
