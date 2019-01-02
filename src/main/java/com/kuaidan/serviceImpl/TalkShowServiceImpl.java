package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.kuaidan.entity.TalkShow;
import com.kuaidan.entity.TalkShowImage;
import com.kuaidan.mapper.TalkShowMapper;
import com.kuaidan.mapper.TalkShowImageMapper;
import com.kuaidan.service.TalkShowService;
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
public class TalkShowServiceImpl implements TalkShowService {

    @Autowired
    private TalkShowMapper talkShowMapper;
    @Autowired
    private TalkShowImageMapper talkShowImageMapper;



    @Override
    public Result pageList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ModelMap> list = talkShowMapper.selectAll(params);
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
     * 详情
     * @param id
     * @return
     */

    @Override
    public Result takeShowDetail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
         if(StringUtils.isBlank(id)){
             code = "-3";
             msg = "主键id不能为空";
         }else {
             TalkShow  talkShow = talkShowMapper.selectByPrimaryKey(id);
             if(talkShow == null){
                 code = "-4";
                 msg = "查询的快蛋说不存在";
                 result.setCode(code);
                 result.setMsg(msg);
                 return result;
             }
             ModelMap modelMap = new ModelMap();
             Map<String,Object> map = talkShowMapper.selectDetailById(id);
             modelMap.addAttribute("map",map);
             List<TalkShowImage> images = talkShowImageMapper.selectImageByTakeShowId(id);
             modelMap.addAttribute("images",images);
             result.setData(modelMap);
             code = Constants.SUCCESS;
             msg = "查询成功";
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
     * 置顶
     * @param id
     * @return
     */

    @Override
    public Result overhead(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else {
                TalkShow  talkShow = talkShowMapper.selectByPrimaryKey(id);
                if(talkShow == null){
                    code = "-4";
                    msg = "置顶的快蛋说不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
            Integer count = talkShowMapper.selectOverheadCount();
                if(count >5){
                    code = "-5";
                    msg = "置顶数已达到最大限度";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShow.setIsOverhead("0");
                talkShowMapper.updateByPrimaryKeySelective(talkShow);
                code = Constants.SUCCESS;
                msg = "置顶成功";
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
     * 取消置顶
     * @param id
     * @return
     */
    @Override
    public Result cancelOverhead(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else {
                TalkShow  talkShow = talkShowMapper.selectByPrimaryKey(id);
                if(talkShow == null){
                    code = "-4";
                    msg = "取消置顶快蛋说不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShow.setIsOverhead("1");
                talkShowMapper.updateByPrimaryKeySelective(talkShow);
                code = Constants.SUCCESS;
                msg = "取消置顶成功";
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
                TalkShow  talkShow = talkShowMapper.selectByPrimaryKey(id);
                if(talkShow == null){
                    code = "-4";
                    msg = "启用的快蛋说不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShow.setIsStartUsing("0");
                talkShowMapper.updateByPrimaryKeySelective(talkShow);
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
                TalkShow  talkShow = talkShowMapper.selectByPrimaryKey(id);
                if(talkShow == null){
                    code = "-4";
                    msg = "禁用的快蛋说不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShow.setIsStartUsing("1");
                talkShowMapper.updateByPrimaryKeySelective(talkShow);
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

    /**
     * 假删除
     * @param id
     * @return
     */

    @Override
    public Result delFlag(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else {
                TalkShow  talkShow = talkShowMapper.selectByPrimaryKey(id);
                if(talkShow == null){
                    code = "-4";
                    msg = "删除的快蛋说不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                talkShow.setDelFlag("1");
                talkShowMapper.updateByPrimaryKeySelective(talkShow);
                code = Constants.SUCCESS;
                msg = "删除成功";
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
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public Result delFlagMany(String[] ids) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(ids == null || ids.length == 0){
                code = "-3";
                msg = "没有删除的快蛋说";
            }
            for (String id : ids){
                TalkShow talkShow = talkShowMapper.selectByPrimaryKey(id);
                talkShow.setDelFlag("1");
                talkShowMapper.updateByPrimaryKeySelective(talkShow);
                code = Constants.SUCCESS;
                msg = "删除成功";
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
