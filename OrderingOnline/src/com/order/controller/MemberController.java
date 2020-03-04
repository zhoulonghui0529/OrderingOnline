package com.order.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.order.exception.ProjectException;
import com.order.po.Member;
import com.order.service.MemberService;
/**
 * 会员控制层controller
 * @author zlh
 *
 */
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//会员注册
	@RequestMapping(value = "/memberSignin")
	public void memberSignin(Member member,HttpServletResponse response) throws Exception{
		if (member!=null&&member.getMemberName()!=null&&member.getMemberPwd()!=null&&member.getMemberPhone()!=null) {
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			//判断会员名是否存在
			if (memberService.queryMemberCount(member)==0) {
				//不存在 注册
				boolean status=memberService.memberSignin(member);
				if (status) {
					printWriter.write("success");
				}else {
					printWriter.write("注册失败");
				}
			}else {
				//存在 返回会员名已注册
				printWriter.write("会员名已经被注册");
			}
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//会员登录
	@RequestMapping(value = "/memberLogin")
	public void memberLogin(Member member,Integer systemId,HttpServletResponse response,HttpSession session) throws Exception{
		if (member!=null&&member.getMemberName()!=null) {
			Member realMember=memberService.memberLogin(member);
			response.setCharacterEncoding("utf-8");
			PrintWriter printWriter=response.getWriter();
			if (realMember!=null) {
				session.setAttribute("memberName", realMember.getMemberName());
				session.setAttribute("memberPwd", realMember.getMemberPwd());
				session.setAttribute("memberId", realMember.getId());
				session.setAttribute("systemId", systemId);
				printWriter.write("success");
			}else {
				printWriter.write("登录失败");
			}
		}else {
			throw new ProjectException("参数错误");
		}
	}
	//会员注销
	@RequestMapping(value = "/memberLogout")
	public void memberLogout(HttpServletResponse response,HttpSession session) throws Exception{
		session.invalidate();
		response.setCharacterEncoding("utf-8");
		response.sendRedirect("views/member/login.html");
		
	}
}
