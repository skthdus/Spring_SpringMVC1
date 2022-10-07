package com.smhrd.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.Member;

@Controller
public class MemberController {
	
	//의존성주입(DI)
	@Autowired
	private MemberMapper memberMapper;
	
	@RequestMapping(value="/member/join", method=RequestMethod.POST)
	public String join(@RequestParam("id")String id, @RequestParam("pw")String pw, @RequestParam("nick")String nick) {
		
		Member member = new Member(id, pw, nick);
		memberMapper.joinMember(member);
		
		return "main";
	}
}
