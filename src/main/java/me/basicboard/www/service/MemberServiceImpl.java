package me.basicboard.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import me.basicboard.www.domain.MemberVO;
import me.basicboard.www.persistence.MemberMapper;
@Log
@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberMapper memberMapper;
	
	@Override
	public MemberVO checkEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.getMember(email);
	}

	@Override
	public void join(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		memberMapper.insertMember(memberVO);
	}

	// id가 존재하면 true
	@Override
	public boolean checkId(String id) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.getMemberId(id)!=null?true:false;
	}
	
	
	
	

}
