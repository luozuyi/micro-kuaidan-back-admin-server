package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShowCollect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TalkShowCollectMapper {
    int deleteByPrimaryKey(String id);

    int insert(TalkShowCollect record);

    int insertSelective(TalkShowCollect record);

    TalkShowCollect selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShowCollect record);

    int updateByPrimaryKey(TalkShowCollect record);
}