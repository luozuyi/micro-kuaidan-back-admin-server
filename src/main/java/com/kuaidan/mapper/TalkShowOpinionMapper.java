package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShowOpinion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TalkShowOpinionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TalkShowOpinion record);

    int insertSelective(TalkShowOpinion record);

    TalkShowOpinion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShowOpinion record);

    int updateByPrimaryKey(TalkShowOpinion record);
}