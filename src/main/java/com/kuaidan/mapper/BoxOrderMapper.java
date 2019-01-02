package com.kuaidan.mapper;

import com.kuaidan.entity.BoxOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BoxOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(BoxOrder record);

    int insertSelective(BoxOrder record);

    BoxOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BoxOrder record);

    int updateByPrimaryKey(BoxOrder record);

    List<Map<String,Object>> selectSelection(BoxOrder record);

    Map<String,Object> selectBoxOrderDetail(String id);

    /**
     * 查询距离当前10天的已发货盒子订单
     * @return
     */
    List<BoxOrder> selectBoxOrderBeforeTenDays();
}