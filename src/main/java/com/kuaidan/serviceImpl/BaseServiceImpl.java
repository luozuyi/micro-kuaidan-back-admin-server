package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.mapper.BaseMapper;
import com.kuaidan.service.BaseService;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PageHelperNew;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.validation.BindingResult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T, ID> {
    @Autowired
    private BaseMapper<T, ID> baseMapper;
    @Override
    public Result deleteByPrimaryKey(ID id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(id == null || id == ""){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                T t = baseMapper.selectByPrimaryKey(id);
                if(t == null){
                    code = "-4";
                    msg = "删除对象不存在";
                }else{
                    baseMapper.deleteByPrimaryKey(id);
                    code = Constants.SUCCESS;
                    msg = "删除成功";
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    @Override
    public Result selectByPrimaryKey(ID id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(id == null || id == ""){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                T t = baseMapper.selectByPrimaryKey(id);
                result.setData(t);
                code = Constants.SUCCESS;
                msg = "成功";
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    @Override
    public Result insert(T record) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            baseMapper.insert(record);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result insertSelective(T record) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            baseMapper.insertSelective(record);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updateByPrimaryKeySelective(T record) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            baseMapper.updateByPrimaryKeySelective(record);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updateByPrimaryKey(T record) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            baseMapper.updateByPrimaryKey(record);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    @Override
    public Result pageList(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum,pageSize);
            List<Map<String,Object>> mapList = baseMapper.selectAllBySelection(params);
            PageInfo<Map<String,Object>> page = new PageInfo<>(mapList);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result selectMapByPrimaryKey(ID id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(id == null || id == ""){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Map<String,Object> map = baseMapper.selectMapByPrimaryKey(id);
                if(map == null){
                    code = "-4";
                    msg = "对象不存在";
                }else{
                    result.setData(map);
                    code = Constants.SUCCESS;
                    msg = "查询成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result pageList(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum,pageSize);
            List<T> list = baseMapper.selectAll();
            PageInfo<T> page = new PageInfo<>(list);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result insertSelective(T record,BindingResult bangResult) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(bangResult.hasErrors()){
                return new Result(bangResult);
            }
            baseMapper.insertSelective(record);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result pageListEntity(Integer pageNum, Integer pageSize, Map<String,Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum,pageSize);
            List<T> ts = baseMapper.selectAllByParams(params);
            PageInfo<T> page = new PageInfo<>(ts);
            result.setData(page);
            code = Constants.SUCCESS;
            msg = "成功";
        } catch (Exception e) {
            code = Constants.ERROR;
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
