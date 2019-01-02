package com.kuaidan.service;

import com.kuaidan.entity.Member;
import com.kuaidan.utils.Result;

public interface MemberService extends BaseService<Member,String>{
    Result detail(String id);
}
