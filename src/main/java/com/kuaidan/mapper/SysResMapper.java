package com.kuaidan.mapper;

import com.kuaidan.entity.SysRes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysResMapper extends BaseMapper<SysRes,String>{
    int deleteByPrimaryKey(String id);

    int insert(SysRes record);

    int insertSelective(SysRes record);

    SysRes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRes record);

    int updateByPrimaryKey(SysRes record);

    SysRes selectByUrlAndMethod(SysRes record);

    List<SysRes> selectChildListById(String id);

    List<SysRes> selectByRoleId(String roleId);
}