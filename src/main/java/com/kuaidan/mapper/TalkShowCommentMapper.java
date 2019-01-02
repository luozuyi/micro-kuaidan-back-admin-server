package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShowComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TalkShowCommentMapper {

    List<ModelMap> selectAllComment(Map<String,Object> params);

    int deleteByPrimaryKey(String id);

    int insert(TalkShowComment record);

    int insertSelective(TalkShowComment record);

    TalkShowComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShowComment record);

    int updateByPrimaryKey(TalkShowComment record);
}