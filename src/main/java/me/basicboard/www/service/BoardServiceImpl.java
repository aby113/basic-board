package me.basicboard.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import me.basicboard.www.domain.BoardVO;
import me.basicboard.www.domain.Criteria;
import me.basicboard.www.persistence.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> listCri(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.getBoardList(cri);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.getBasicboard(bno);
	}

	@Override
	public void register(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.insertBasicboard(boardVO);
	}

	@Override
	public void modify(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateBasicboard(boardVO);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.deleteBasicboard(bno);
	}

	@Override
	public int getBoardCount() throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.getBoardCount();
	}

}
