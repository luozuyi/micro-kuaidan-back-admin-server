package com.kuaidan.mapper;

import com.kuaidan.entity.ServiceOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    /**
     * 根据状态查询单个会员的服务订单数
     * @param map
     * @return
     */
    Integer selectCountByStatus(Map<String,Object> map);

    /**
     * 查询用户订单总金额
     * @param memberId
     * @return
     */
    BigDecimal selectTotalPrice(String memberId);
}