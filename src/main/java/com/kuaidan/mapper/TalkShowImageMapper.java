package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShowImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TalkShowImageMapper {
    List<TalkShowImage> selectImageByTakeShowId(String takeShowId);

    int deleteByPrimaryKey(String id);

    int insert(TalkShowImage record);

    int insertSelective(TalkShowImage record);

    TalkShowImage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShowImage record);

    int updateByPrimaryKey(TalkShowImage record);
}