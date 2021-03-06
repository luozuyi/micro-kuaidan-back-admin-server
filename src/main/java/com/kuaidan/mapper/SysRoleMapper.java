package com.kuaidan.mapper;

import com.kuaidan.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole,String>{
    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    SysRole selectByRoleName(String roleName);
}