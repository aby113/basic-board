package me.basicboard.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import me.basicboard.www.domain.MemberVO;
import me.basicboard.www.persistence.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberMapper memberMapper;
	
	@Override
	public MemberVO checkEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.getMember(email);
	}

}
