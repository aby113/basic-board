package me.basicboard.www;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;
import me.basicboard.www.domain.MemberVO;
import me.basicboard.www.persistence.MemberMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Log
public class TestMember{
	@Inject
	private MemberMapper memberMapper;
	
	private MemberVO memberVO;
	@Before
	public void setUp()throws Exception{
		memberVO = new MemberVO();
	}
	
	@Test
	public void testLogin()throws Exception{

		String id = "aby113";
		String pw = "hi2";
		MemberVO memberVO = memberMapper.getMember(id);
		System.out.println(memberVO);
		assertTrue(memberVO.checkPw(pw));
	}
	
	@Test
	@Ignore
	public void testJoin()throws Exception{
		memberVO.setEmail("adh113@naver.com");
		memberVO.setId("adh113");
		memberVO.setPw("1234");
		memberMapper.insertMember(memberVO);
	}
	
}
