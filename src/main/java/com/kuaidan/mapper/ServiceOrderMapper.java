package com.kuaidan.mapper;

import com.kuaidan.entity.ServiceOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ServiceOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(ServiceOrder record);

    int insertSelective(ServiceOrder record);

    ServiceOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceOrder record);

    int updateByPrimaryKey(ServiceOrder record);

    List<Map<String,Object>> selectOrderSelection(ServiceOrder record);

    Map<String,Object> selectDetail(String id);

    /**
     * 根据状态查询订单数量
     * @param status
     * @return
     */
    Integer selectServiceOrderCountByType(String status);
}