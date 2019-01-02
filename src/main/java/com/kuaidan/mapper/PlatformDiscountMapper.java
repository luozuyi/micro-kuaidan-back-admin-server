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

    int insertSelective(Map<String,Object> map);

    PlatformDiscount selectByPrimaryKey(String id);

    List<ModelMap> selectAll();

    BigDecimal selectDiscountByType(Map<String,Object> map);

    int updateByPrimaryKeySelective(Map<String,Object> map);

    int updateByPrimaryKey(PlatformDiscount record);


}