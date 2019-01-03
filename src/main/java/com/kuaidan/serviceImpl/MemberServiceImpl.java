package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.entity.Member;
import com.kuaidan.mapper.*;
import com.kuaidan.service.MemberService;
import com.kuaidan.utils.Constants;
import com.kuaidan.utils.PageHelperNew;
import com.kuaidan.utils.Result;
import javafx.beans.binding.ObjectExpression;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member,String> implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BoxOrderMapper boxOrderMapper;
    @Autowired
    private ServiceOrderMapper serviceOrderMapper;
    @Autowired
    private TalkShowMapper talkShowMapper;
    @Autowired
    private TalkShowCollectMapper talkShowCollectMapper;

    @Override
    public Result detail(String id) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            if(StringUtils.isBlank(id)){
                code = "-3";
                msg = "主键id不能为空";
            }else{
                Map<String,Object> data = new HashMap<>();
                Member member = memberMapper.selectByPrimaryKey(id);
                if(member == null){
                    code = "-4";
                    msg = "不存在该会员";
                }else{
                    data.put("member",member);
                    /*查询用户盒子数量*/
                    Integer memberBoxCount = boxOrderMapper.selectMemberBoxCount(id);
                    data.put("memberBoxCount",memberBoxCount);
                    /*查询待付款订单*/
                    Map<String,Object> params1 = new HashMap<>();
                    params1.put("memberId",id);
                    params1.put("status","0");
                    Integer status0Count  = serviceOrderMapper.selectCountByStatus(params1);
                    data.put("status0Count",status0Count);

                    /*查询服务中订单数*/
                    Map<String,Object> params2 = new HashMap<>();
                    params2.put("memberId",id);
                    params2.put("status","1");
                    Integer status1Count  = serviceOrderMapper.selectCountByStatus(params2);
                    data.put("status1Count",status1Count);

                    /*查询完成订单数*/
                    Map<String,Object> params3 = new HashMap<>();
                    params3.put("memberId",id);
                    params3.put("status","2");
                    Integer status2Count  = serviceOrderMapper.selectCountByStatus(params3);
                    data.put("status2Count",status2Count);

                    /*查询用户快蛋说数量*/
                    Integer memberTalkShowCount = talkShowMapper.selectMemberTalkShowCount(id);
                    data.put("memberTalkShowCount",memberTalkShowCount);

                    /*查询用户快蛋说收藏数量*/
                    Integer memberTalkCollectShowCount = talkShowCollectMapper.selectMemberTalkCollectShowCount(id);
                    data.put("memberTalkCollectShowCount",memberTalkCollectShowCount);

                    /*订单总额*/
                    BigDecimal selectTotalPrice = serviceOrderMapper.selectTotalPrice(id);
                    data.put("totalPrice",selectTotalPrice);

                    result.setData(data);
                    code = Constants.SUCCESS;
                    msg = "成功";
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
    public Result pageListByParams(Integer pageNum, Integer pageSize, Map<String, Object> params) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum,pageSize);
            List<Map<String,Object>> memberList = memberMapper.selectAllBySelection(params);
            for (Map<String,Object> member:memberList) {
                String id = (String)member.get("id");
                /*查询用户盒子数量*/
                Integer memberBoxCount = boxOrderMapper.selectMemberBoxCount(id);
                member.put("memberBoxCount",memberBoxCount);
                /*查询待付款订单*/
                Map<String,Object> params1 = new HashMap<>();
                params1.put("memberId",id);
                params1.put("status","0");
                Integer status0Count  = serviceOrderMapper.selectCountByStatus(params1);
                member.put("status0Count",status0Count);

                /*查询服务中订单数*/
                Map<String,Object> params2 = new HashMap<>();
                params2.put("memberId",id);
                params2.put("status","1");
                Integer status1Count  = serviceOrderMapper.selectCountByStatus(params2);
                member.put("status1Count",status1Count);

                /*查询完成订单数*/
                Map<String,Object> params3 = new HashMap<>();
                params3.put("memberId",id);
                params3.put("status","2");
                Integer status2Count  = serviceOrderMapper.selectCountByStatus(params3);
                member.put("status2Count",status2Count);

                /*查询用户快蛋说数量*/
                Integer memberTalkShowCount = talkShowMapper.selectMemberTalkShowCount(id);
                member.put("memberTalkShowCount",memberTalkShowCount);

                /*查询用户快蛋说收藏数量*/
                Integer memberTalkCollectShowCount = talkShowCollectMapper.selectMemberTalkCollectShowCount(id);
                member.put("memberTalkCollectShowCount",memberTalkCollectShowCount);

                /*订单总额*/
                BigDecimal selectTotalPrice = serviceOrderMapper.selectTotalPrice(id);
                member.put("totalPrice",selectTotalPrice);
            }
            PageInfo<Map<String,Object>> page = new PageInfo<>(memberList);
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
