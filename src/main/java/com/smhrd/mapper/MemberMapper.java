package com.smhrd.mapper;

import java.util.List;

import com.smhrd.model.Member;

public interface MemberMapper {
	public void joinMember(Member member);
	
	public Member loginMember(Member member);
	
	public void updateMember(Member member);
	
	public List<Member> selectAllMember();
	
	//2. deleteMember() 작성
	public void deleteMember(String id);
	
	//3. mapper.xml 에 sql 작성 (특정회원삭제) 
	
}
