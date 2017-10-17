package me.basicboard.www.persistence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import me.basicboard.www.domain.MemberVO;

public interface MemberMapper {

	@Select("SELECT * FROM member WHERE email = #{email}")
	public MemberVO getMember(@Param("email")String email)throws Exception;
	
	
	
}
