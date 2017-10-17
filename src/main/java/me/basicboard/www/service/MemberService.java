package me.basicboard.www.service;

import me.basicboard.www.domain.MemberVO;

public interface MemberService {

	public MemberVO checkEmail(String email)throws Exception;
	
}
