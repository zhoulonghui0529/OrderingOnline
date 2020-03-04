package com.order.mapper;

import java.util.List;

import com.order.po.Member;

/**
 * 会员mapper接口
 * @author zlh
 *
 */
public interface MemberMapper {
	//添加会员
	public int insertMember(Member member) throws Exception;
	//查询会员
	public List<Member> findMember(Member member) throws Exception;
	//查询会员总数
	public int findMemberCount(Member member) throws Exception;
}
