package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShowShare;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TalkShowShareMapper {
    int deleteByPrimaryKey(String id);

    int insert(TalkShowShare record);

    int insertSelective(TalkShowShare record);

    TalkShowShare selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShowShare record);

    int updateByPrimaryKey(TalkShowShare record);
}