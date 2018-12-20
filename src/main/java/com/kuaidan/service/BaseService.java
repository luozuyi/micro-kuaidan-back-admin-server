package com.kuaidan.service;

import com.kuaidan.utils.Result;
import org.springframework.validation.BindingResult;

import java.io.Serializable;
import java.util.Map;

public interface BaseService<T,ID extends Serializable> {

    Result deleteByPrimaryKey(ID id);

    Result insert(T record);

    Result insertSelective(T record);

    Result selectByPrimaryKey(ID id);

    Result updateByPrimaryKeySelective(T record);

    Result updateByPrimaryKey(T record);

    Result pageList(Integer pageNum, Integer pageSize, Map<String, Object> params);

    Result selectMapByPrimaryKey(ID id);

    Result pageList(Integer pageNum, Integer pageSize);

    Result insertSelective(T record, BindingResult bangResult);

    Result pageListEntity(Integer pageNum, Integer pageSize, Map<String, Object> params);
}
