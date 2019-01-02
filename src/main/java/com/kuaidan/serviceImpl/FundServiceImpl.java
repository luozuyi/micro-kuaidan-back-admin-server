package com.kuaidan.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.kuaidan.entity.Fund;
import com.kuaidan.mapper.FundMapper;
import com.kuaidan.service.FundService;
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
 * @date 2018/12/22
 */
@Transactional
@Service
public class FundServiceImpl implements FundService {

    @Autowired
    private FundMapper fundMapper;

    @Override
    public Result getFundList(Fund fund, Integer pageNum, Integer pageSize) {
        Result result = new Result();
        String code = Constants.FAIL;
        String msg = "初始化";
        try {
            PageHelperNew.startPage(pageNum, pageSize);
            List<Map<String,Object>> mapList = fundMapper.selectFundSelection(fund);
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
                msg="资金id不能为空";
            }else {
                Map<String,Object> map=fundMapper.selectDetail(id);
                code = Constants.SUCCESS;
                msg = "查询成功";
                result.setData(map);
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
