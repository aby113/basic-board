package me.basicboard.www.controller;

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

import lombok.extern.java.Log;
import me.basicboard.www.domain.MemberDTO;

@Log
@Controller
@RequestMapping("/sample")
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void testGET(Model model) throws Exception {
		model.addAttribute("memberDTO", new MemberDTO());
	}

	@ResponseBody
	@RequestMapping(value = "/checkAjaxId", method = RequestMethod.POST)
	public ResponseEntity<Object> testAjax(@RequestBody @Valid MemberDTO memberDTO, BindingResult bindingResult)
			throws Exception {

		log.info("test메서드 작동");
		ResponseEntity<Object> entity = null;
		if (bindingResult.hasErrors()) {
			log.warning("유효성 에러");
			return new ResponseEntity(memberDTO, HttpStatus.BAD_REQUEST);
		}
		
		try {
			entity = new ResponseEntity("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			log.warning("에러발생");
			e.printStackTrace();
			entity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	public String test(@Valid MemberDTO memberDTO, BindingResult bindingResult)
			throws Exception {

		log.info("test메서드 작동");
		if(bindingResult.hasErrors()){
			log.warning("에러작동");
			return "/sample/test";
		}

		return "/sample/test";
	}
	
}
