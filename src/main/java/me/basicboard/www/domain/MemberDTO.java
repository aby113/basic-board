package me.basicboard.www.domain;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class MemberDTO{

	private Integer mno;
	@NotBlank(message="이메일을 작성해 주세요.")
	private String email;
	@NotBlank
	private String email2;
	@NotBlank(message="아이디를 입력해 주세요.")
	private String id;
	@NotBlank(message="패스워드를 입력해 주세요.")
	private String pw;
	private String pwConfirm;
	
	public void copy(MemberVO copy){
		
		this.mno = copy.getMno();
		this.email = copy.getEmail();
		this.email2 = copy.getEmail2();
		this.id = copy.getId();
		this.pw = copy.getPw();
		this.pwConfirm = copy.getPwConfirm();
	}
	
	
}
