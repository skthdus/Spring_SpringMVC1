package com.smhrd.model;

public class Member {
	private String id;
	private String pw;
	private String nick;
	
	public Member(String id, String pw, String nick) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}
	
	//@ModelAttribute 용
	public Member() {
		
	}
	
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNick() {
		return nick;
	}
	
}
