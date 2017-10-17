package me.basicboard.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import me.basicboard.www.domain.MemberVO;
import me.basicboard.www.service.MemberService;

@RestController
@Log
@RequestMapping("/member")
public class LoginController {

	@Inject
	private MemberService memberService;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody MemberVO memberVO, HttpSession session)throws Exception{
		
		log.info("login메서드 작동");
		log.warning("email" + memberVO.getEmail() + "비번: " + memberVO.getPw());
		ResponseEntity<String> entity = null;
		try{
			MemberVO userInfo = memberService.checkEmail(memberVO.getEmail());
			// db에 해당 id정보가 존재할 경우
			if(userInfo != null){
				// 패스워드가 맞지않을경우 로그인실패 처리한다
				if(!userInfo.checkPw(memberVO.getPw())) throw new Exception("로그인 실패");

				session.setAttribute("login", userInfo);
				entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
				log.warning(entity.toString());
				return entity;
			}
			throw new Exception("로그인 실패");
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}
	
		return entity;
	}

}
