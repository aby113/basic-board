package me.basicboard.www.service;

import java.util.List;

import me.basicboard.www.domain.BoardVO;
import me.basicboard.www.domain.Criteria;

public interface BoardService {
	
	public List<BoardVO> listCri(Criteria cri)throws Exception;
	
	public int getBoardCount()throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void register(BoardVO boardVO)throws Exception;
	
	public void modify(BoardVO boardVO)throws Exception;
	
	public void remove(Integer bno)throws Exception;
}
