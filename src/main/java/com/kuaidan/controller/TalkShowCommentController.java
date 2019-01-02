package com.kuaidan.controller;

import com.kuaidan.service.TalkShowCommentService;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TalkShowCommentController {

    @Autowired
    private TalkShowCommentService talkShowCommentService;

    /**
     * 分页条件查询评论
     * @param pageNum    当前页
     * @param pageSize   一页显示多少条
     * @param params      参数
     * @param talkShowId  快蛋说id
     * @return
     */
    @GetMapping(value = "v1/auth/talk-show-comment/paginations")
    public Result pageList(String talkShowId,Integer pageNum, Integer pageSize,@RequestParam Map<String, Object> params){
        return talkShowCommentService.pageList(talkShowId,pageNum,pageSize,params);
    }

    /**
     * 启用
     * @param id  评论id
     * @return
     */
    @PatchMapping(value = "v1/auth/talk-show-comment/startUsing")
    public Result startUsing(String id){
        return talkShowCommentService.startUsing(id);
    }

    /**
     * 禁用
     * @param id  评论id
     * @return
     */
    @PatchMapping(value = "v1/auth/talk-show-comment/disabled")
    public Result disabled(String id){
        return talkShowCommentService.disabled(id);
    }

}
