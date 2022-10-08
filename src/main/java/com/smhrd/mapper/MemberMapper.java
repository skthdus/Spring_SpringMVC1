package com.smhrd.mapper;

import java.util.List;

import com.smhrd.model.Member;

public interface MemberMapper {
	public void joinMember(Member member);
	
	public Member loginMember(Member member);
	
	public void updateMember(Member member);
	
	public List<Member> selectAllMember();
	
}
