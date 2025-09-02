package com.mycompany.oracle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.oracle.dao.BoardDao;
import com.mycompany.oracle.dto.BoardDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping (value = "/bwrite")
	public String bwrite(HttpServletRequest request, Model model, HttpSession session) {
		String sid = (String) session.getAttribute("sessionId");
		if (sid == null) {
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다");
			model.addAttribute("url", "login");
			return "alert/alert";
		}
		return "writeForm";
	}
	@RequestMapping (value = "/bwriteOk")
	public String bwriteOk(HttpServletRequest request, Model model) {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = request.getParameter("bwriter");
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.boardWriteDao(btitle, bcontent, bwriter);
		return "redirect:blist";
	}
	
	@RequestMapping (value = "/blist")
	public String blist(HttpServletRequest request, Model model, HttpSession session) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao(); // 모든 글을 리스트로 가져오기
		model.addAttribute("boardDtos", boardDtos);
		model.addAttribute("boardCount", boardDao.allBoardCountDao()); // 모든 글 개수 전달하기
		return "boardList";
	}
	
	@RequestMapping (value = "/boarddelete")
	public String boarddelete(HttpServletRequest request, Model model, HttpSession session) {
		String bnum = request.getParameter("bnum");
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardDeleteDao(bnum);
		if (result == 1) {
			model.addAttribute("msg", "성공적으로 삭제되었습니다.");
		    model.addAttribute("url", "blist");
		    return "alert/alert";
		}
		return "redirect:blist";
	}
	
	@RequestMapping (value = "/boardview")
	public String boardview(HttpServletRequest request, Model model) {
		String bnum = request.getParameter("bnum");
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		boardDao.updateHitDao(bnum); // 조회수 올리기
		BoardDto boardDto = boardDao.boardViewDao(bnum);
		model.addAttribute("boardDto", boardDto);
		return "boardview";
	}
	
	@RequestMapping (value = "/boardModify")
	public String boardModify(HttpServletRequest request, Model model) {
		String bnum = request.getParameter("bnum");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int result = boardDao.boardModifyDao(bnum, btitle, bcontent);
		if (result == 1) {
			model.addAttribute("msg", "성공적으로 수정되었습니다.");
		    model.addAttribute("url", "blist"); 
		} else {
			model.addAttribute("msg", "글 수정 실패하였습니다.");
		    model.addAttribute("url", "blist");
		}
		return "alert/alert";
	}
}
