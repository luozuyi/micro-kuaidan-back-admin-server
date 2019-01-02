package com.kuaidan.quartz;

import com.kuaidan.entity.BoxOrder;
import com.kuaidan.mapper.BoxOrderMapper;
import com.kuaidan.service.BoxOrderService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author W1665
 */
@Service
@Transactional
public class ConfirmOrderQuartzCore extends QuartzJobBean {

    @Autowired
    private BoxOrderMapper boxOrderMapper;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        //先查询距离当前十天的已发货的盒子订单
        List<BoxOrder> list=boxOrderMapper.selectBoxOrderBeforeTenDays();
        //有此种盒子订单，进行自动确认收货
        if (list!=null && list.size()>0){
            for (BoxOrder boxOder :
                    list) {
                boxOder.setStatus("2");
                //修改为确认收货
                boxOrderMapper.updateByPrimaryKeySelective(boxOder);
            }
        }
    }


}
