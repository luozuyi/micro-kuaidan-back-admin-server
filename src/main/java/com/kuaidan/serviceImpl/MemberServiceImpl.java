package com.kuaidan.serviceImpl;

import com.kuaidan.entity.Member;
import com.kuaidan.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member,String> implements MemberService {
}
