package com.kuaidan.serviceImpl;

import com.kuaidan.mapper.FundMapper;
import com.kuaidan.mapper.MemberMapper;
import com.kuaidan.mapper.ServiceOrderMapper;
import com.kuaidan.mapper.TalkShowMapper;
import com.kuaidan.service.StatisticsDataService;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by W1665 on 2018/12/28.
 */
@Transactional
@Service
public class StatisticsDataServiceImpl implements StatisticsDataService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private ServiceOrderMapper serviceOrderMapper;

    @Autowired
    private FundMapper fundMapper;

    @Autowired
    private TalkShowMapper talkShowMapper;

    @Override
    public Result getData() {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            //授权登录会员数
            Integer memberCount = memberMapper.selectAllMemberCount();
            //查询服务中订单数量
            Integer inServiceOrderCount = serviceOrderMapper.selectServiceOrderCountByType("1");
            //查询服务完成订单数量
            Integer overServiceOrderCount = serviceOrderMapper.selectServiceOrderCountByType("2");
            //资金收入
            BigDecimal sumFund=fundMapper.sumMoney();
            //快蛋说数量
            Integer talkShowCount=talkShowMapper.selectAllCount();
            Map<String, Object> map = new HashMap<>(5);
            map.put("memberCount",memberCount);
            map.put("inServiceOrderCount",inServiceOrderCount);
            map.put("overServiceOrderCount",overServiceOrderCount);
            map.put("sumFund",sumFund);
            map.put("talkShowCount",talkShowCount);
            code=Constants.SUCCESS;
            msg="查询成功";
            result.setData(map);
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
