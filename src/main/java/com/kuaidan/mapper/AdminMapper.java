package com.kuaidan.mapper;

import com.kuaidan.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface AdminMapper extends BaseMapper<Admin,String >{
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByAdminName(String adminName);

    Map<String,Object> selectAdminAndRoleByPrimaryKey(String id);
}