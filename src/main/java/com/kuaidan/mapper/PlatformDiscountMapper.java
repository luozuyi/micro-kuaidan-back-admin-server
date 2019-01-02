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

    int insertSelective(Map<String,Object> map);//����ۿ۹���

    PlatformDiscount selectByPrimaryKey(String id);//��ѯһ����������

    List<ModelMap> selectAll();//��ѯ���е��ۿ۹���

    BigDecimal selectDiscountByType(Map<String,Object> map);//�������Ͳ�ѯ�ۿ�

    int updateByPrimaryKeySelective(Map<String,Object> map);//�༭�ۿ۹���

    int updateByPrimaryKey(PlatformDiscount record);


}