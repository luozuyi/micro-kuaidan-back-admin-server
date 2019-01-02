package com.kuaidan.mapper;

import com.kuaidan.entity.PlatformBoxConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlatformBoxConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformBoxConfig record);

    int insertSelective(PlatformBoxConfig record);

    PlatformBoxConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PlatformBoxConfig record);

    int updateByPrimaryKey(PlatformBoxConfig record);
}