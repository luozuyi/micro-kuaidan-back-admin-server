package com.kuaidan.mapper;

import com.kuaidan.entity.Citys;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CitysMapper {
    int deleteByPrimaryKey(String id);

    int insert(Citys record);

    int insertSelective(Citys record);

    Citys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Citys record);

    int updateByPrimaryKey(Citys record);
}