package com.smhrd.myapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.smhrd.mapper.MemberMapper;
import com.smhrd.model.Member;

//Model(데이터), View 반환
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
	
	//ModelAttribute : 오브젝트로 파라미터값들을 받아줄 때
	@PostMapping("/member/login")
	public String login(@ModelAttribute Member member, HttpSession session) {
		Member loginM = memberMapper.loginMember(member);
		session.setAttribute("loginM", loginM);
		return "main";
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginM");
		return "redirect:/main";
	}
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute Member member, HttpSession session) {
		memberMapper.updateMember(member);
		session.setAttribute("loginM", member);
		return "main";
	}
	
	//Model : Controller에서 생성한 데이터를 담아서 View로 전달할 때 사용하는 객체
	
	@GetMapping("/member/select")
	public String select(Model model) {
		List<Member> memberList = memberMapper.selectAllMember();
		model.addAttribute("memberList", memberList); //model객체에 데이터 저장
		return "select";
	}
	
	//1. delete()메서드 작성 
	//- 쿼리스트링으로 보내준 id 값 받기
	//mapper interface : deleteMember() 호출
	//전체회원조회 페이지로 이동 -> 삭제한 회원이 안 보이는지 확인
	@GetMapping("/member/delete")
	public String delete(@RequestParam("id")String id) {
		memberMapper.deleteMember(id);
		return "redirect:/member/select";
	}

}
