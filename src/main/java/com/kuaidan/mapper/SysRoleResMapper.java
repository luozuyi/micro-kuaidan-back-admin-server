package com.kuaidan.mapper;

import com.kuaidan.entity.SysRoleRes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysRoleResMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRoleRes record);

    int insertSelective(SysRoleRes record);

    SysRoleRes selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleRes record);

    int updateByPrimaryKey(SysRoleRes record);

    int deleteByResId(String resId);

    List<SysRoleRes> selectByRoleId(String roleId);
}