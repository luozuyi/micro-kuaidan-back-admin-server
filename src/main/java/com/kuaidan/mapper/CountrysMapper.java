package com.kuaidan.mapper;

import com.kuaidan.entity.Countrys;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CountrysMapper {
    int deleteByPrimaryKey(String id);

    int insert(Countrys record);

    int insertSelective(Countrys record);

    Countrys selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Countrys record);

    int updateByPrimaryKey(Countrys record);
}