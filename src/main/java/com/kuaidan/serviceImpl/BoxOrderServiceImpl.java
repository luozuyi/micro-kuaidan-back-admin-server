package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.entity.BoxLogistics;
import com.kuaidan.entity.BoxOrder;
import com.kuaidan.mapper.BoxLogisticsMapper;
import com.kuaidan.mapper.BoxOrderMapper;
import com.kuaidan.service.BoxOrderService;
import com.kuaidan.utils.CommonUtil;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PageHelperNew;
import com.kuaidan.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author W1665
 * @date 2018/12/22
 */
@Transactional
@Service
public class BoxOrderServiceImpl implements BoxOrderService {

    @Autowired
    private BoxOrderMapper boxOrderMapper;

    @Autowired
    private BoxLogisticsMapper boxLogisticsMapper;

    @Override
    public Result getBoxOrderList(BoxOrder boxOrder, Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Map<String,Object>> mapList = boxOrderMapper.selectSelection(boxOrder);
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
    public Result updateBoxOrder(String id,String name,String sendTime,String expressCompany,String expressNumber) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isBlank(id)){
                code="-3";
                msg="盒子订单id不能为空";
            }else if (StringUtils.isBlank(name)){
                code="-4";
                msg="发货人名称不能为空";
            }else if (StringUtils.isBlank(sendTime)){
                code="-5";
                msg="发货时间不能为空";
            }else if (StringUtils.isBlank(expressCompany)){
                code="-6";
                msg="快递公司不能为空";
            }else if (StringUtils.isBlank(expressNumber)){
                code="-7";
                msg="快递单号不能为空";
            }else {
                BoxOrder boxOrder = boxOrderMapper.selectByPrimaryKey(id);
                if (boxOrder == null) {
                    code = "-8";
                    msg = "该盒子订单不存在";
                } else if (!StringUtils.equals(boxOrder.getStatus(),"0")){
                    code="-9";
                    msg="该盒子订单的状态不是待发货，无法确认发货";
                } else{
                    BoxLogistics boxLogistics = new BoxLogistics();
                    boxLogistics.setId(CommonUtil.getUUID());
                    boxLogistics.setCreateTime(new Date());
                    boxLogistics.setDelFlag("0");
                    boxLogistics.setBoxOrderId(id);
                    boxLogistics.setExpressCompany(expressCompany);
                    boxLogistics.setExpressNumber(expressNumber);
                    //新增盒子快递信息
                    boxLogisticsMapper.insertSelective(boxLogistics);
                    boxOrder.setSendPerson(name);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    boxOrder.setSendTime(sdf.parse(sendTime));
                    //修改盒子订单信息
                    boxOrderMapper.updateByPrimaryKeySelective(boxOrder);
                    code = Constants.SUCCESS;
                    msg = "确认发货成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
                msg="盒子订单id不能为空";
            }else {
                Map<String,Object> map=boxOrderMapper.selectBoxOrderDetail(id);
                result.setData(map);
                code = Constants.SUCCESS;
                msg = "查询成功";
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
    public Result sureReceive(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if (StringUtils.isBlank(id)){
                code="-3";
                msg="盒子订单id不能为空";
            }else {
                BoxOrder boxOrder = boxOrderMapper.selectByPrimaryKey(id);
                if (boxOrder==null){
                    code="-4";
                    msg="盒子订单不存在";
                }else if (!StringUtils.equals(boxOrder.getStatus(),"1")){
                    code="-5";
                    msg="只有状态为已发货的盒子才能确认收货";
                }else {
                    boxOrder.setStatus("2");
                    boxOrderMapper.updateByPrimaryKeySelective(boxOrder);
                    code=Constants.SUCCESS;
                    msg="确认收货成功";
                }
            }
        } catch (Exception e) {
            code = Constants.ERROR;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            msg = "后台繁忙";
            e.printStackTrace();
        }
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
