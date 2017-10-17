package me.basicboard.www.domain;

public class MemberVO {

	private Integer mno;
	private String email;
	private String id;
	private String pw;
	
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean checkPw(String pw){
		boolean result = false;
	
		if(pw.equals(this.pw)){
			result = true;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", email=" + email + ", id=" + id + ", pw=" + pw + "]";
	}
	
	
}
