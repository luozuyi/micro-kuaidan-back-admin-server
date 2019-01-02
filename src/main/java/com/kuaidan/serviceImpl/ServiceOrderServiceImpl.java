package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.entity.ServiceOrder;
import com.kuaidan.mapper.ServiceOrderMapper;
import com.kuaidan.service.ServiceOrderService;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PageHelperNew;
import com.kuaidan.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/12/21
 */
@Transactional
@Service
public class ServiceOrderServiceImpl implements ServiceOrderService {

    @Autowired
    private ServiceOrderMapper serviceOrderMapper;

    @Override
    public Result getServiceOrderSelection(ServiceOrder serviceOrder, Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Map<String,Object>> mapList = serviceOrderMapper.selectOrderSelection(serviceOrder);
            PageInfo page = new PageInfo(mapList);
            code=Constants.SUCCESS;
            msg="查询成功";
            result.setData(page);
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
    public Result getDetail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isBlank(id)){
                code="-3";
                msg="服务id不能为空";
            }else {
                Map<String, Object> stringObjectMap = serviceOrderMapper.selectDetail(id);
                code=Constants.SUCCESS;
                msg="查询成功";
                result.setData(stringObjectMap);
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
}
