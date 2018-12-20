package com.kuaidan.serviceImpl;

import com.kuaidan.entity.Admin;
import com.kuaidan.entity.SysRole;
import com.kuaidan.mapper.AdminMapper;
import com.kuaidan.mapper.SysRoleMapper;
import com.kuaidan.service.AdminService;
import com.kuaidan.utils.CommonUtil;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PatternUtil;
import com.kuaidan.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

@Transactional
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin,String> implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Result addAdmin(String adminName, String qq, String password, String roleId, String isDelFlag, String surePassword) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(isDelFlag)){
                isDelFlag = "0";
            }
            if(StringUtils.isBlank(adminName)){
                code = "-3";
                msg = "管理员登陆名不能为空";
            }else if(StringUtils.isBlank(password)){
                code = "-4";
                msg = "密码不能为空";
            }else if(StringUtils.isBlank(surePassword)){
                code = "-5";
                msg = "确认密码不能为空";
            }else if(!PatternUtil.patternString(password, "password")){
                code = "-6";
                msg = "密码格式不正确";
            }else if(!password.equals(surePassword)){
                code = "-7";
                msg = "两次密码不一致";
            }else if(!isDelFlag.equals(Constants.AdminIsDisable.DISABLE.getIsDisable()) && !isDelFlag.equals(Constants.AdminIsDisable.UNDISABLE.getIsDisable())){
                code = "-10";
                msg = "请正确选择是否禁用";
            }else{
                Admin admin_db = adminMapper.selectByAdminName(adminName);
                if(admin_db != null){
                    code = "-8";
                    msg = "已存在该管理员";
                }else{
                    if(StringUtils.isNotBlank(roleId)){
                        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
                        if(sysRole == null){
                            code = "-9";
                            msg = "要分配的角色不存在";
                        }else{
                            Admin admin = new Admin();
                            String uuid = CommonUtil.getUUID();
                            admin.setAdminName(adminName);
                            admin.setCreateTime(new Date());
                            admin.setPassword(password);
                            admin.setId(uuid);
                            admin.setRoleId(roleId);
                            admin.setDelFlag(isDelFlag);
                            admin.setQq(qq);
                            adminMapper.insertSelective(admin);
                            code = Constants.SUCCESS;
                            msg = "成功";
                        }
                    }else{
                        code ="-10";
                        msg = "分配角色不能为空";
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
    public Result findById(String adminId) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(adminId)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Map<String,Object> map = adminMapper.selectAdminAndRoleByPrimaryKey(adminId);
                result.setData(map);
                code = Constants.SUCCESS;
                msg = "查询成功";
            }
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
    public Result update(String adminId, String password, String roleId, String isDelFlag, String surePassword,String token) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            String adminIdToken = CommonUtil.getAdminId(token);
            if(StringUtils.isBlank(adminId)){
                code = "-3";
                msg = "主键id不能为空";
            }else if(StringUtils.isBlank(password)){
                code = "-4";
                msg = "密码不能为空";
            }else if(StringUtils.isBlank(surePassword)){
                code = "-5";
                msg = "确认密码不能为空";
            }else if(StringUtils.isBlank(isDelFlag)){
                code = "-6";
                msg = "选择是否禁用";
            }else if(!PatternUtil.patternString(password, "password")){
                code = "-7";
                msg = "密码格式不正确";
            }else if(!password.equals(surePassword)){
                code = "-8";
                msg = "两次密码不一致";
            }else if(!isDelFlag.equals(Constants.AdminIsDisable.DISABLE.getIsDisable()) && !isDelFlag.equals(Constants.AdminIsDisable.UNDISABLE.getIsDisable())){
                code = "-9";
                msg = "请正确选择是否禁用";
            }else if(!adminId.equals(adminIdToken)){
                code = "-11";
                msg = "不是当前用户";
            }else{
                Admin admin_db = adminMapper.selectByPrimaryKey(adminId);
                if(admin_db == null){
                    code = "-10";
                    msg = "不存在该管理员";
                    result.setCode(code);
                    result.setMsg(msg);
                    return result;
                }
                admin_db.setPassword(password);
                admin_db.setRoleId(roleId);
                admin_db.setDelFlag(isDelFlag);
                adminMapper.updateByPrimaryKeySelective(admin_db);
                Result response  = restTemplate.getForEntity("http://micro-kuaidan-zuul-server/back-sso/v1/admins/logout?token="+token,Result.class).getBody();
                if("0".equals(response.getCode())){
                    code = Constants.SUCCESS;
                    msg = "修改成功";
                }else {
                    code = "-11";
                    msg = "修改失败";
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
    public Result updateDel(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(id);
                if(admin == null){
                    code = "-4";
                    msg = "管理员不存在";
                }else if(!"1".equals(admin.getDelFlag())){
                    code = "-5";
                    msg = "只有禁止的账号才能启用";
                } else {
                    admin.setDelFlag("0");
                    adminMapper.updateByPrimaryKeySelective(admin);
                    code = Constants.SUCCESS;
                    msg = "启用成功";
                }
            }
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
    public Result delFlag(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(id);
                if(admin == null){
                    code = "-4";
                    msg = "管理员不存在";
                }else if(!"0".equals(admin.getDelFlag())){
                    code = "-5";
                    msg = "只有正常的账号才能禁用";
                } else {
                    admin.setDelFlag("1");
                    adminMapper.updateByPrimaryKeySelective(admin);
                    code = Constants.SUCCESS;
                    msg = "禁用成功";
                }
            }
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
    public Result delete(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                adminMapper.deleteByPrimaryKey(id);
                code = Constants.SUCCESS;
                msg = "删除成功";
            }
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
    public Result updateImage(String id,String imagePath) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(id);
                if(admin == null){
                    code = "-4";
                    msg = "管理员不存在";
                }else {
                    admin.setHeadImage(imagePath);
                    adminMapper.updateByPrimaryKeySelective(admin);
                    code = Constants.SUCCESS;
                    msg = "修改成功";
                }
            }
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
    public Result updateTelephone(String id, String telephone) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(id);
                if(admin == null){
                    code = "-4";
                    msg = "管理员不存在";
                }else {
                    admin.setTelephone(telephone);
                    adminMapper.updateByPrimaryKeySelective(admin);
                    code = Constants.SUCCESS;
                    msg = "修改成功";
                }
            }
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
    public Result updateQq(String id, String qq) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Admin admin = adminMapper.selectByPrimaryKey(id);
                if(admin == null){
                    code = "-4";
                    msg = "管理员不存在";
                }else {
                    admin.setQq(qq);
                    adminMapper.updateByPrimaryKeySelective(admin);
                    code = Constants.SUCCESS;
                    msg = "修改成功";
                }
            }
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
