package me.basicboard.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.java.Log;
import me.basicboard.www.domain.BoardVO;
import me.basicboard.www.domain.Criteria;
import me.basicboard.www.domain.PageMaker;
import me.basicboard.www.service.BoardService;

@Controller
@RequestMapping("/board")
@Log
public class BoardContoller {
	
	@Inject
	private BoardService boardService;
	
	@RequestMapping(value="/listPage", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.getBoardCount(cri));
		
		model.addAttribute("list", boardService.listSearchCri(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "/board/list";
	}
	
	@RequestMapping(value="/readPage", method = RequestMethod.GET)
	public String readGET(@ModelAttribute("cri")Criteria cri
			, Integer bno
			, Model model)throws Exception{
		model.addAttribute("boardVO", boardService.read(bno));
		log.info(cri.toString());
		return "/board/read";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String writePOST(RedirectAttributes rttr, Model model, BoardVO boardVO)throws Exception{
		log.warning(boardVO.toString());
		boardService.register(boardVO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/modifyPage", method = RequestMethod.GET)
	public String modifyGET(Integer bno, @ModelAttribute("cri")Criteria cri, Model model)throws Exception{
		
		model.addAttribute("boardVO", boardService.read(bno));
		return "/board/modify";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyPOST(Criteria cri,BoardVO boardVO, RedirectAttributes rttr)throws Exception{

		boardService.modify(boardVO);
		rttr.addFlashAttribute("msg", "SUCCESS");
		rttr.addAttribute("bno", boardVO.getBno());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/readPage";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String removePOST(Integer bno, RedirectAttributes rttr, Criteria cri)throws Exception{
		boardService.remove(bno);
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		return "redirect:/board/listPage";
	}
	
	
	
}
