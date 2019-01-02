package com.kuaidan.mapper;

import com.kuaidan.entity.PlatformServiceCycleConfig;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlatformServiceCycleConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(PlatformServiceCycleConfig record);

    int insertSelective(PlatformServiceCycleConfig record);

    PlatformServiceCycleConfig selectByPrimaryKey(String id);

    String selectByType(Integer type);;//根据次数类型查询周期id

    int updateByPrimaryKeySelective(PlatformServiceCycleConfig record);

    int updateByPrimaryKey(PlatformServiceCycleConfig record);
}