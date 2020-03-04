package com.order.service;

import java.util.List;

import com.order.po.Member;

/**
 * 会员业务层service接口
 * @author zlh
 *
 */
public interface MemberService {
	//会员注册
	public boolean memberSignin(Member member) throws Exception;
	//会员登录
	public Member memberLogin(Member member) throws Exception;
	//会员查询
	public List<Member> queryMember(Member member) throws Exception;
	//查询会员总数
	public int queryMemberCount(Member member) throws Exception;
}

