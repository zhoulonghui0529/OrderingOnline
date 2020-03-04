package com.order.po;
/**
 * 会员po类
 * @author zlh
 *
 */
public class Member {
	private Integer id;
	private String memberName;
	private String memberPwd;
	private String memberPhone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", memberName=" + memberName + ", memberPwd=" + memberPwd + ", memberPhone="
				+ memberPhone + "]";
	}
	
}
