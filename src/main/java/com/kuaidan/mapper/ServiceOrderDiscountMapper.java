package com.kuaidan.mapper;

import com.kuaidan.entity.ServiceOrderDiscount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServiceOrderDiscountMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceOrderDiscount record);

    int insertSelective(ServiceOrderDiscount record);

    ServiceOrderDiscount selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceOrderDiscount record);

    int updateByPrimaryKey(ServiceOrderDiscount record);
}