package com.kuaidan.service;

import com.kuaidan.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface TalkShowCommentService {

    /**
     * 分页条件查询评论
     * @param pageNum    当前页
     * @param pageSize   一页显示多少条
     * @param params      参数
     * @param talkShowId  快蛋说id
     * @return
     */
    Result pageList(String talkShowId,Integer pageNum, Integer pageSize, Map<String, Object> params);

    /**
     * 启用
     * @param id 评论id
     * @return
     */
    Result startUsing(String id);

    /**
     * 禁用
     * @param id 评论id
     * @return
     */
    Result disabled(String id);
}
