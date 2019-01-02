package com.kuaidan.mapper;

import com.kuaidan.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper extends BaseMapper<Member,String>{
    int deleteByPrimaryKey(String id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    /**
     * 查询授权登录会员数量
     * @return
     */
    Integer selectAllMemberCount();
}