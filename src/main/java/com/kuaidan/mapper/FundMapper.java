package com.kuaidan.mapper;

import com.kuaidan.entity.Fund;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface FundMapper {
    int deleteByPrimaryKey(String id);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);

    List<Map<String,Object>> selectFundSelection(Fund record);

    Map<String,Object> selectDetail(String id);

    /**
     * 查询总资金
     * @return
     */
    BigDecimal sumMoney();
}