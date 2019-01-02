package com.kuaidan.mapper;

import com.kuaidan.entity.PlatformDiscount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PlatformDiscountMapper {

    int deleteByPrimaryKey(String id);

    int insert(PlatformDiscount record);

    int insertSelective(Map<String,Object> map);//添加折扣规则

    PlatformDiscount selectByPrimaryKey(String id);//查询一个规则详情

    List<ModelMap> selectAll();//查询所有的折扣规则

    BigDecimal selectDiscountByType(Map<String,Object> map);//根据类型查询折扣

    int updateByPrimaryKeySelective(Map<String,Object> map);//编辑折扣规则

    int updateByPrimaryKey(PlatformDiscount record);


}