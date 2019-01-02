package com.kuaidan.mapper;

import com.kuaidan.entity.ServiceOrderAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServiceOrderAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceOrderAddress record);

    int insertSelective(ServiceOrderAddress record);

    ServiceOrderAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceOrderAddress record);

    int updateByPrimaryKey(ServiceOrderAddress record);
}