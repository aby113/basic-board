package me.basicboard.www.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import me.basicboard.www.domain.BoardVO;
import me.basicboard.www.domain.Criteria;

public interface BoardMapper {

	@Select("SELECT * FROM basicboard"
			+ " ORDER BY bno desc"
			+ " limit #{pageStart}, #{perPageNum}")
	public List<BoardVO> getBoardList(Criteria cri)throws Exception;
	
	@Select("SELECT * FROM basicboard WHERE bno = #{bno}")
	public BoardVO getBasicboard(Integer bno)throws Exception;
	
	@Select("SELECT COUNT(*) FROM basicboard")
	public int getBoardCount()throws Exception;
	
	@Insert("INSERT INTO basicboard(title, writer, content) values(#{title}, #{writer}, #{content})")
	public void insertBasicboard(BoardVO boardVO)throws Exception;
	
	@Update("UPDATE basicboard SET title = #{title}, content = #{content}"
			+ "WHERE bno = #{bno}")
	public void updateBasicboard(BoardVO boardVO)throws Exception;
	
	@Delete("DELETE FROM basicboard WHERE bno = #{bno}")
	public void deleteBasicboard(Integer bno)throws Exception;
	
	
}
