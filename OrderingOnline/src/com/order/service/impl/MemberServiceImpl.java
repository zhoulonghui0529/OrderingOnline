package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.order.mapper.MemberMapper;
import com.order.po.Member;
import com.order.service.MemberService;
/**
 * 会员业务service 接口实现
 * @author zlh
 *
 */
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	//会员注册
	@Override
	public boolean memberSignin(Member member) throws Exception {
		// TODO Auto-generated method stub
		//判断是否有语句执行成功
		if (memberMapper.insertMember(member)>0) {
			return true;
		}
		return false;
	}
	//会员登录验证
	@Override
	public Member memberLogin(Member member) throws Exception {
		// TODO Auto-generated method stub
		List<Member> members=memberMapper.findMember(member);
		Member realMember=members.get(0);
		//比较两个对象中的密码是否相同
		if (realMember.getMemberPwd().equals(member.getMemberPwd())) {
			return realMember;
		}
		return null;
	}
	//会员信息查询
	@Override
	public List<Member> queryMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.findMember(member);
	}
	@Override
	public int queryMemberCount(Member member) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.findMemberCount(member);
	}

}
