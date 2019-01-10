package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShowCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TalkShowCollectMapper {
    List<TalkShowCollect> selectByTalkShowId(String talkShowId);

    int deleteByPrimaryKey(String id);

    int insert(TalkShowCollect record);

    int insertSelective(TalkShowCollect record);

    TalkShowCollect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShowCollect record);

    int updateByPrimaryKey(TalkShowCollect record);

    /*查询用户快蛋说数收藏量*/
    Integer selectMemberTalkCollectShowCount(String memberId);
}