package com.kuaidan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BaseMapper<T,ID extends Serializable> {
    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<Map<String,Object>> selectAllBySelection(Map<String, Object> params);

    Map<String,Object> selectMapByPrimaryKey(ID id);

    List<T> selectAll();

    List<T> selectAllByParams(Map<String, Object> params);
}
