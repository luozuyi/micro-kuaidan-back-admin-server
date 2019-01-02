package com.kuaidan.mapper;

import com.kuaidan.entity.PlatformServiceNumConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlatformServiceNumConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformServiceNumConfig record);

    int insertSelective(PlatformServiceNumConfig record);

    PlatformServiceNumConfig selectByPrimaryKey(String id);

    String selectByType(Integer type);

    int updateByPrimaryKeySelective(PlatformServiceNumConfig record);

    int updateByPrimaryKey(PlatformServiceNumConfig record);
}