package com.kuaidan.serviceImpl;

import com.kuaidan.entity.SysRes;
import com.kuaidan.entity.SysRole;
import com.kuaidan.entity.SysRoleRes;
import com.kuaidan.mapper.SysResMapper;
import com.kuaidan.mapper.SysRoleMapper;
import com.kuaidan.mapper.SysRoleResMapper;
import com.kuaidan.service.SysRoleService;
import com.kuaidan.utils.CommonUtil;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PatternUtil;
import com.kuaidan.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Transactional
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole, String> implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleResMapper sysRoleResMapper;
    @Autowired
    private SysResMapper sysResMapper;
    @Override
    public Result add(String roleName, String sequence, String[] sysResIds) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(roleName)){
                code = "-3";
                msg = "角色名称不能为空";
            }else if(StringUtils.isBlank(sequence)){
                code = "-4";
                msg = "排序不能为空";
            }else if(!PatternUtil.patternString(sequence, "num")){
                code = "-5";
                msg = "排序必须是数字";
            }else{
                SysRole sysRole_db = sysRoleMapper.selectByRoleName(roleName);
                if(sysRole_db != null){
                    code = "-6";
                    msg = "该角色已经存在";
                }else{
                    Boolean flag = true;
                    for (String sysResId:sysResIds) {
                        SysRes sysRes_db = sysResMapper.selectByPrimaryKey(sysResId);
                        if(sysRes_db == null){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag){
                        code = "-7";
                        msg = "存在无效权限id";
                    }else{
                        String sysRoleId = CommonUtil.getUUID();
                        SysRole sysRole = new SysRole();
                        sysRole.setId(sysRoleId);
                        sysRole.setCreateTime(new Date());
                        sysRole.setRoleName(roleName);
                        sysRole.setSequence(sequence);
                        sysRole.setDelFlag("0");
                        sysRoleMapper.insertSelective(sysRole);

                        for (String sysResId:sysResIds) {
                            SysRoleRes sysRoleSysRes = new SysRoleRes();
                            sysRoleSysRes.setId(CommonUtil.getUUID());
                            sysRoleSysRes.setCreateTime(new Date());
                            sysRoleSysRes.setDelFlag("0");
                            sysRoleSysRes.setResId(sysResId);
                            sysRoleSysRes.setRoleId(sysRoleId);
                            sysRoleResMapper.insertSelective(sysRoleSysRes);
                        }
                        code = Constants.SUCCESS;
                        msg = "成功";
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

    @Override
    public Result findById(String roleId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(roleId)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                SysRole sysRole_db = sysRoleMapper.selectByPrimaryKey(roleId);
                if(sysRole_db == null){
                    code = "-4";
                    msg = "查询对像不存在";
                }else{
                    List<SysRes> sysResList = sysResMapper.selectByRoleId(roleId);
                    Map<String,Object> map = new HashMap<>();
                    map.put("id", sysRole_db.getId());
                    map.put("createTime", sysRole_db.getCreateTime());
                    map.put("delFlag", sysRole_db.getDelFlag());
                    map.put("sequence", sysRole_db.getSequence());
                    map.put("roleName", sysRole_db.getRoleName());
                    map.put("sysResList", sysResList);
                    result.setData(map);
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
    public Result update(String roleId, String roleName, String sequence, String[] sysResIds) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(roleId)){
                code = "-3";
                msg = "主键id不能为空";
            }else if(StringUtils.isBlank(roleName)){
                code = "-4";
                msg = "角色名称不能为空";
            }else if(StringUtils.isBlank(sequence)){
                code = "-5";
                msg = "排序不能为空";
            }else if(!PatternUtil.patternString(sequence, "num")){
                code = "-6";
                msg = "排序必须是数字";
            }else{
                SysRole sysRole_db_id = sysRoleMapper.selectByPrimaryKey(roleId);
                if(sysRole_db_id == null){
                    code = "-8";
                    msg = "要修改的角色不存在";
                }else{
                    SysRole sysRole_db = sysRoleMapper.selectByRoleName(roleName);
                    if(sysRole_db != null && !sysRole_db.getId().equals(roleId)){
                        code = "-8";
                        msg = "已经存在相同角色名数据";
                    }else{
                        Boolean flag = true;
                        for (String sysResId:sysResIds) {
                            SysRes sysRes_db = sysResMapper.selectByPrimaryKey(sysResId);
                            if(sysRes_db == null){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag){
                            code = "-9";
                            msg = "存在无效权限id";
                        }else{
                            sysRole_db_id.setRoleName(roleName);
                            sysRole_db_id.setSequence(sequence);
                            sysRoleMapper.updateByPrimaryKeySelective(sysRole_db_id);
                            List<SysRoleRes> sysRoleSysResList = sysRoleResMapper.selectByRoleId(roleId);
                            for (SysRoleRes sysRoleSysRes:sysRoleSysResList) {
                                sysRoleResMapper.deleteByPrimaryKey(sysRoleSysRes.getId());
                            }
                            for (String sysResId:sysResIds) {
                                SysRoleRes sysRoleSysRes = new SysRoleRes();
                                sysRoleSysRes.setId(CommonUtil.getUUID());
                                sysRoleSysRes.setCreateTime(new Date());
                                sysRoleSysRes.setDelFlag("0");
                                sysRoleSysRes.setResId(sysResId);
                                sysRoleSysRes.setRoleId(roleId);
                                sysRoleResMapper.insertSelective(sysRoleSysRes);
                            }
                            code = Constants.SUCCESS;
                            msg = "成功";
                        }
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

    @Override
    public Result list() {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            List<SysRole> sysRoles = sysRoleMapper.selectAll();
            result.setData(sysRoles);
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
}
