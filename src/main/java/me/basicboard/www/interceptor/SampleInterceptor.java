package me.basicboard.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.java.Log;
import me.basicboard.www.domain.MemberVO;
@Log
public class SampleInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("인터셉터 작동");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("login");
		log.warning("세션체크: " + memberVO);
		if(memberVO != null)return true;
	
		response.sendRedirect("/basic/board/listPage?msg=LOGIN_FAIL");
		return false;
	}

	
	
	
}
