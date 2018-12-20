package com.kuaidan.serviceImpl;

import com.kuaidan.entity.SysRes;
import com.kuaidan.mapper.SysResMapper;
import com.kuaidan.mapper.SysRoleResMapper;
import com.kuaidan.service.SysResService;
import com.kuaidan.utils.CommonUtil;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Transactional
@Service
public class SysResServiceImpl extends BaseServiceImpl<SysRes,String> implements SysResService{
    @Autowired
    private SysResMapper sysResMapper;
    @Autowired
    private SysRoleResMapper sysRoleResMapper;
    @Override
    public Result add(SysRes sysRes) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(sysRes.getResName())){
                code = "-3";
                msg = "权限名称不能为空";
            }else if(StringUtils.isBlank(sysRes.getType())){
                code = "-4";
                msg = "权限类型不能为空";
            }else if(!"0".equals(sysRes.getType()) && !"1".equals(sysRes.getType()) && !"2".equals(sysRes.getType())){
                code = "-5";
                msg = "权限类型只能是栏目，菜单，或者按钮";
            }else{
                //说明是按钮（接口），则必须唯一
                if(!"0".equals(sysRes.getType()) && !"1".equals(sysRes.getType())){
                    if(StringUtils.isBlank(sysRes.getMethod())){
                        code = "-6";
                        msg = "权限请求方式不能为空";
                    }else if(StringUtils.isBlank(sysRes.getUrl())){
                        code = "-7";
                        msg = "权限路径不能为空";
                    }else if(StringUtils.isBlank(sysRes.getParentId())){
                        code = "-8";
                        msg = "父id不能为空";
                    }else{
                        SysRes sysRes_db = sysResMapper.selectByUrlAndMethod(sysRes);
                        if(sysRes_db != null){
                            code = "-9";
                            msg = "已有相同权限";
                        }else{
                            sysRes.setId(CommonUtil.getUUID());
                            sysRes.setCreateTime(new Date());
                            sysRes.setDelFlag("0");
                            sysResMapper.insertSelective(sysRes);
                            code = Constants.SUCCESS;
                            msg = "成功";
                        }
                    }
                }else{//说明是栏目 或者菜单
                    sysRes.setId(CommonUtil.getUUID());
                    sysRes.setCreateTime(new Date());
                    sysRes.setDelFlag("0");
                    sysResMapper.insertSelective(sysRes);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            msg = "系统繁忙";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result update(SysRes sysRes) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(sysRes.getId())){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                SysRes sysRes_db_id = sysResMapper.selectByPrimaryKey(sysRes.getId());
                if(sysRes_db_id == null){
                    code = "-5";
                    msg = "权限不存在";
                    result.setCode(code);
                    result.setMsg(msg);
                    return  result;
                }
                if(!"0".equals(sysRes_db_id.getType()) && !"1".equals(sysRes_db_id.getType())){
                    SysRes sysRes_db = sysResMapper.selectByUrlAndMethod(sysRes);
                    if(sysRes_db != null && !sysRes_db.getId().equals(sysRes.getId())){
                        code = "-4";
                        msg = "已存在该权限不能修改";
                    }else{
                        sysResMapper.updateByPrimaryKeySelective(sysRes);
                        code = Constants.SUCCESS;
                        msg = "成功";
                    }
                }else{
                    sysResMapper.updateByPrimaryKeySelective(sysRes);
                    code = Constants.SUCCESS;
                    msg = "成功";
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
            code = Constants.ERROR;
            msg = "系统繁忙";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result getList() {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            List<SysRes> sysResList = sysResMapper.selectAll();
            result.setData(sysResList);
            code = Constants.SUCCESS;
            msg = "查询成功";
        } catch (Exception e) {
            e.printStackTrace();
            code = Constants.ERROR;
            msg = "系统繁忙";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    @Override
    public Result updateDelFlag(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                SysRes sysRes_db_id = sysResMapper.selectByPrimaryKey(id);
                if(sysRes_db_id == null){
                    code = "-4";
                    msg = "删除的对象不存在";
                }else{
                    List<SysRes> sysRes = sysResMapper.selectChildListById(id);
                    if(sysRes.isEmpty()){
                        sysRes_db_id.setDelFlag("1");
                        sysResMapper.updateByPrimaryKeySelective(sysRes_db_id);
                        sysRoleResMapper.deleteByResId(id);
                        code = Constants.SUCCESS;
                        msg = "删除成功";
                    }else{
                        code = "-5";
                        msg = "存在子节点，无法删除该节点";
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            msg = "系统繁忙";
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
