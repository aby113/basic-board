package me.basicboard.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;
import me.basicboard.www.domain.BoardVO;
import me.basicboard.www.domain.Criteria;
import me.basicboard.www.persistence.BoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Log
public class DaoTest {

	
	@Inject
	private BoardMapper boardMapper; 

	private Criteria cri;
	private BoardVO boardVO;
	
	@Before
	public void setup()throws Exception{
		cri = new Criteria();
		boardVO = new BoardVO();
	}
	
	@Test
	public void testList()throws Exception{
		cri.setPage(1);
		cri.setPerPageNum(10);
	
		List<BoardVO> list = boardMapper.getBoardList(cri);
		for(BoardVO vo : list){
			log.info(vo.toString());
		}
	}
	
	@Test
	public void testRead() throws Exception{
		boardVO = boardMapper.getBasicboard(1);
		log.info(boardVO.toString());
	}
	
	@Test
	public void testUpdate()throws Exception{
		boardVO.setBno(2);
		boardVO.setTitle("updateTitle");
		boardVO.setContent("updateContent");
		boardMapper.updateBasicboard(boardVO);
		log.info(boardMapper.getBasicboard(2).toString());
	}
	
	@Test
	public void testDelete()throws Exception{
		boardMapper.deleteBasicboard(3);
	}
	
	@Test
	public void testCount()throws Exception{
		int result=boardMapper.getBoardCount(cri);
		log.info(result + "");
	}
	
	@Test
	public void testSearList()throws Exception{
		cri.setSearchType("t");
		cri.setKeyword("title100");
		List<BoardVO> list = boardMapper.getSearchBasicBoardList(cri);
		
		for(BoardVO vo : list){
			log.info(vo.toString());
		}
		
	}
	
	
	@Test
	@Ignore
	public void testInsert()throws Exception{
		
		for(int i = 102; i <= 555; i++){
			boardVO.setTitle("title" + i);
			boardVO.setWriter("writer" + i);
			boardVO.setContent("content" + i);
			boardMapper.insertBasicboard(boardVO);
		}
	
	}
	
}
