package com.kuaidan.mapper;

import com.kuaidan.entity.TalkShow;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface TalkShowMapper {
    Integer selectOverheadCount();

    List<ModelMap> selectAll(Map<String,Object> params);

    Map<String,Object> selectDetailById(String id);

    int deleteByPrimaryKey(String id);

    int insert(TalkShow record);

    int insertSelective(TalkShow record);

    TalkShow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TalkShow record);

    int updateByPrimaryKey(TalkShow record);

    /**
     * 查询快蛋说数量
     * @return
     */
    Integer selectAllCount();
    /*查询用户快蛋说数量*/
    Integer selectMemberTalkShowCount(String memberId);

}
