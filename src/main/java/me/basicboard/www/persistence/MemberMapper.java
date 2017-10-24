package me.basicboard.www.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import me.basicboard.www.domain.MemberVO;

public interface MemberMapper {

	@Select("SELECT * FROM member WHERE email = #{email}")
	public MemberVO getMember(@Param("email")String email)throws Exception;
	
	@Insert("INSERT INTO member(email, id, pw) VALUES(#{email}, #{id}, #{pw})")
	public void insertMember(MemberVO memberVO)throws Exception;
	
	@Select("SELECT 1 FROM member WHERE email = #{email}")
	public Integer getMemberEmail(@Param("email")String email)throws Exception;
	
	@Select("SELECT 1 FROM member WHERE id = #{id}")
	public Integer getMemberId(@Param("id")String id)throws Exception;
	
	
	
}
