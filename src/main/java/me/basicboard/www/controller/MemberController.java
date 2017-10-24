package me.basicboard.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.java.Log;
import me.basicboard.www.domain.MemberDTO;
import me.basicboard.www.domain.MemberVO;
import me.basicboard.www.service.MemberService;

@Log
@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService memberService;

	@RequestMapping(value="/joinPage", method = RequestMethod.GET)
	public String joinPage(Model model)throws Exception{
		model.addAttribute("memberDTO", new MemberDTO());
		return "/board/join";
	}
	
	@ResponseBody
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
	
	@RequestMapping(value="/join", method = RequestMethod.POST)
	public String join(@Valid MemberDTO memberDTO, BindingResult bindingResult, RedirectAttributes rttr)throws Exception{
		log.info("join메서드 동작");
		//	log.warning(memberDTO.toString() + memberVO.toString());
		if(bindingResult.hasErrors()){
			log.warning("유효하지않음");
			log.warning(bindingResult.getAllErrors().toString());
		//	rttr.addAttribute("memberDTO", memberDTO);
			rttr.addFlashAttribute("msg", "FAIL");
			return "redirect:/member/joinPage";
		}
		memberDTO.setEmail(memberDTO.getEmail() + memberDTO.getEmail2());
		memberService.join(new MemberVO().copy(memberDTO));
		return "redirect:/board/listPage";
	}

	@ResponseBody
	@RequestMapping(value="/checkEmail", method = RequestMethod.POST, produces="application/text; charset=utf8")
	public ResponseEntity<String> checkEmail(@RequestBody MemberVO memberVO,BindingResult bindingResult)throws Exception{
		log.info("checkEmail작동");
		ResponseEntity<String> entity = null;
				
		log.warning(memberVO.getEmail());
		
		try{
			if(memberService.checkEmail(memberVO.getEmail()) != null)throw new Exception("이메일 존재하지않음");
			
			entity = new ResponseEntity<>("사용 가능한 이메일 입니다.", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>("사용 불가능한 이메일 입니다.", HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="/checkId", method = RequestMethod.POST, produces="application/text; charset=utf8")
	public ResponseEntity<String> checkId(@RequestBody MemberVO memberVO)throws Exception{
		log.info("메서드 동작");
		log.warning(memberVO.getId());
		ResponseEntity<String> entity = null;
		try{
			if(memberService.checkId(memberVO.getId())) throw new Exception();

			entity = new ResponseEntity<>("사용 가능한 아이디 입니다.", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>("사용 불가능한 아이디 입니다.", HttpStatus.BAD_REQUEST);
		}
		log.warning(entity.toString());
		return entity;
	}
	
	
	
	
	
	
}
