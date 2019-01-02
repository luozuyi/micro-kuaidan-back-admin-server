package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.entity.TalkShowComment;
import com.kuaidan.mapper.TalkShowCommentMapper;
import com.kuaidan.service.TalkShowCommentService;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PageHelperNew;
import com.kuaidan.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class TalkShowCommentServiceImpl implements TalkShowCommentService {

    @Autowired
    private TalkShowCommentMapper talkShowCommentMapper;

    @Override
    public Result pageList(String talkShowId,Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            params.put("id", talkShowId);
            PageHelperNew.startPage(pageNum, pageSize);
            List<ModelMap> list = talkShowCommentMapper.selectAllComment(params);
            PageInfo<ModelMap> page = new PageInfo<>(list);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "查询成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 启用
     * @param id
     * @return
     */
    @Override
    public Result startUsing(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else {
                TalkShowComment talkShowComment = talkShowCommentMapper.selectByPrimaryKey(id);
                if(talkShowComment == null){
                    code = "-4";
                    msg = "启用的快蛋说评论不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShowComment.setIsStartUsing("0");
                talkShowCommentMapper.updateByPrimaryKeySelective(talkShowComment);
                code = Constants.SUCCESS;
                msg = "启用成功";
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    /**
     * 禁用
     * @param id
     * @return
     */
    @Override
    public Result disabled(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else {
                TalkShowComment talkShowComment = talkShowCommentMapper.selectByPrimaryKey(id);
                if(talkShowComment == null){
                    code = "-4";
                    msg = "禁用的快蛋说评论不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShowComment.setIsStartUsing("1");
                talkShowCommentMapper.updateByPrimaryKeySelective(talkShowComment);
                code = Constants.SUCCESS;
                msg = "禁用成功";
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}