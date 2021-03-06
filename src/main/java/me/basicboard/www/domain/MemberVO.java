package me.basicboard.www.domain;

import lombok.Data;

@Data
public class MemberVO{

	private Integer mno;
	private String email;
	private String email2;
	private String id;
	private String pw;
	private String pwConfirm;

	public boolean checkPw(String pw){
		boolean result = false;
	
		if(pw.equals(this.pw)){
			result = true;
		}
		return result;
	}
	
	public MemberVO copy(MemberDTO copy){
		
		this.mno = copy.getMno();
		this.email = copy.getEmail();
		this.email2 = copy.getEmail2();
		this.id = copy.getId();
		this.pw = copy.getPw();
		this.pwConfirm = copy.getPwConfirm();
		return this;
	}
	
	
	
}
