package com.kuaidan.mapper;

import com.kuaidan.entity.BoxLogistics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoxLogisticsMapper {
    int deleteByPrimaryKey(String id);

    int insert(BoxLogistics record);

    int insertSelective(BoxLogistics record);

    BoxLogistics selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BoxLogistics record);

    int updateByPrimaryKey(BoxLogistics record);
}