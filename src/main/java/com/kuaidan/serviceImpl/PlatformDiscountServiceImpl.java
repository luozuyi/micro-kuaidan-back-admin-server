package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.entity.PlatformDiscount;
import com.kuaidan.entity.PlatformServiceCycleConfig;
import com.kuaidan.entity.PlatformServiceNumConfig;
import com.kuaidan.mapper.PlatformDiscountMapper;
import com.kuaidan.mapper.PlatformServiceCycleConfigMapper;
import com.kuaidan.mapper.PlatformServiceNumConfigMapper;
import com.kuaidan.service.PlatformDiscountService;
import com.kuaidan.utils.CommonUtil;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PageHelperNew;
import com.kuaidan.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzz on 2018/12/25.
 **/
@Transactional
@Service
public class PlatformDiscountServiceImpl implements PlatformDiscountService {
    @Autowired
    private PlatformDiscountMapper platformDiscountMapper;
    @Autowired
    private PlatformServiceCycleConfigMapper platformServiceCycleConfigMapper;
    @Autowired
    private PlatformServiceNumConfigMapper platformServiceNumConfigMapper;

    @Override
    public Result pageList(Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<ModelMap> list = platformDiscountMapper.selectAll();
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

    @Override
    public Result insertDiscount(Map<String, Object> map) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            Integer discount1 = Integer.valueOf(map.get("numType").toString());
            if (StringUtils.isBlank(map.get("cycleType").toString())) {
                code = "-1";
                msg = "服务周期不能为空";
            } else if (StringUtils.isBlank(map.get("numType").toString())) {
                code = "-2";
                msg = "服务次数不能为空";
            } else if (discount1 == null && discount1 > 1 && discount1 <= 0) {
                code = "-3";
                msg = "折扣规则错误";
            } else {
                Integer cycleType = Integer.valueOf(map.get("cycleType").toString());
                Integer numType = Integer.valueOf(map.get("numType").toString());
                String serviceCycleConfigId = platformServiceCycleConfigMapper.selectByType(cycleType);//通过cycleType获取到id
                String serviceNumConfigId = platformServiceNumConfigMapper.selectByType(numType);//通过numType获取到id
                Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("serviceCycleConfigId", serviceCycleConfigId);
                map1.put("serviceNumConfigId", serviceNumConfigId);
                BigDecimal discount = platformDiscountMapper.selectDiscountByType(map1);//通过两个条件查询是否已存在折扣
                if (discount != null) {//如果存在就报错
                    code = "-1";
                    msg = "你添加的规则已重复！";
                } else {//如果不存在就添加新的规则
                    map.put("id", CommonUtil.getUUID());
                    map.put("createTime", new Date());
                    map.put("delFlag", "0");
                    if (StringUtils.isBlank(serviceCycleConfigId)) {//如果没有这个服务周期就增加一个服务周期
                        PlatformServiceCycleConfig platformServiceCycleConfig = new PlatformServiceCycleConfig();
                        platformServiceCycleConfig.setId(CommonUtil.getUUID());
                        serviceCycleConfigId = platformServiceCycleConfig.getId();
                        platformServiceCycleConfig.setCreateTime(new Date());
                        platformServiceCycleConfig.setDelFlag("0");
                        platformServiceCycleConfig.setType(cycleType);
                        platformServiceCycleConfigMapper.insertSelective(platformServiceCycleConfig);
                    } else if (StringUtils.isBlank(serviceNumConfigId)) {//如果没有这个服务月数就增加一个服务月数
                        PlatformServiceNumConfig platformServiceNumConfig = new PlatformServiceNumConfig();
                        platformServiceNumConfig.setId(CommonUtil.getUUID());
                        serviceNumConfigId = platformServiceNumConfig.getId();
                        platformServiceNumConfig.setCreateTime(new Date());
                        platformServiceNumConfig.setDelFlag("0");
                        platformServiceNumConfig.setType(numType);
                        platformServiceNumConfigMapper.insertSelective(platformServiceNumConfig);
                    }
                    map.put("serviceCycleConfigId", serviceCycleConfigId);
                    map.put("serviceNumConfigId", serviceNumConfigId);
                    platformDiscountMapper.insertSelective(map);
                    code = Constants.SUCCESS;
                    msg = "添加成功";
                }
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

    @Override
    public Result updateDiscount(Map<String, Object> map) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            Integer cycleType = Integer.valueOf(map.get("cycleType").toString());
            String serviceCycleConfigId = platformServiceCycleConfigMapper.selectByType(cycleType);//通过cycleType获取到id
            Integer numType = Integer.valueOf(map.get("numType").toString());
            String serviceNumConfigId = platformServiceNumConfigMapper.selectByType(numType);//通过numType获取到id
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("serviceCycleConfigId", serviceCycleConfigId);
            map1.put("serviceNumConfigId", serviceNumConfigId);
            BigDecimal discount = platformDiscountMapper.selectDiscountByType(map1);//通过两个条件查询是否已存在折扣
            PlatformDiscount platformDiscount = platformDiscountMapper.selectByPrimaryKey((String) map.get("id"));
            if (discount != null && (!(serviceCycleConfigId.equals(platformDiscount.getServiceCycleConfigId()) && serviceNumConfigId.equals(platformDiscount.getServiceNumConfigId())))) {//如果存在就报错
                code = "-1";
                msg = "你添加的规则已重复！";
            } else {//如果不存在就添加新的规则
                String id = (String) map.get("id");
                if (StringUtils.isBlank(id)) {
                    code = "-1";
                    msg = "折扣id不能为空";
                } else {
                    if (StringUtils.isBlank(serviceCycleConfigId)) {//如果没有这个服务周期就增加一个服务周期
                        PlatformServiceCycleConfig platformServiceCycleConfig = new PlatformServiceCycleConfig();
                        platformServiceCycleConfig.setId(CommonUtil.getUUID());
                        serviceCycleConfigId = platformServiceCycleConfig.getId();
                        platformServiceCycleConfig.setCreateTime(new Date());
                        platformServiceCycleConfig.setDelFlag("0");
                        platformServiceCycleConfig.setType(cycleType);
                        platformServiceCycleConfigMapper.insertSelective(platformServiceCycleConfig);
                    } else if (StringUtils.isBlank(serviceNumConfigId)) {//如果没有这个服务月数就增加一个服务月数
                        PlatformServiceNumConfig platformServiceNumConfig = new PlatformServiceNumConfig();
                        platformServiceNumConfig.setId(CommonUtil.getUUID());
                        serviceNumConfigId = platformServiceNumConfig.getId();
                        platformServiceNumConfig.setCreateTime(new Date());
                        platformServiceNumConfig.setDelFlag("0");
                        platformServiceNumConfig.setType(numType);
                        platformServiceNumConfigMapper.insertSelective(platformServiceNumConfig);
                    }
                    map.put("serviceCycleConfigId", serviceCycleConfigId);
                    map.put("serviceNumConfigId", serviceNumConfigId);
                    platformDiscountMapper.updateByPrimaryKeySelective(map);
                    code = Constants.SUCCESS;
                    msg = "修改成功";
                }
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

    @Override
    public Result deleteDiscount(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isBlank(id)) {
                code = "-1";
                msg = "折扣id不能为空";
            } else {
                PlatformDiscount platformDiscount = platformDiscountMapper.selectByPrimaryKey(id);
                platformDiscount.setDelFlag("1");
                Map<String, Object> map = new HashMap<>();
                map.put("id", platformDiscount.getId());
                map.put("delFlag", platformDiscount.getDelFlag());
                platformDiscountMapper.updateByPrimaryKeySelective(map);
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

    @Override
    public Result selectById(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isBlank(id)) {
                code = "-1";
                msg = "折扣id不能为空";
            } else {
                PlatformDiscount platformDiscount = platformDiscountMapper.selectByPrimaryKey(id);
                result.setData(platformDiscount);
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
}
