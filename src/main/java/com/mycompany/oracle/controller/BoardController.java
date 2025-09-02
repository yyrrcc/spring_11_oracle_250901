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
	
	
	// 디자인 추가된 게시판
	@RequestMapping (value = "/pagelist")
	public String pagelist(HttpServletRequest request, Model model) {
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		int totalCount = boardDao.allBoardCountDao(); // 총 글 수
		
		int pageSize = 10; // 1페이지 당 출력될 글의 개수
		int pageNum = 1; // 유저가 클릭한 페이지 번호, 초기값 설정
		int blockSize = 5; // 페이지 블럭에 표시 될 페이지의 수
		
		if (request.getParameter("pageNum") != null) { // 링크 타고 들어온 경우, 아니면 초기값 1
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // 유저가 클릭한 페이지의 번호
		}
		
		int startRow = (pageNum - 1) * pageSize + 1; // 페이징 되었을 때 시작 페이지 번호
		int endRow = pageNum * pageSize; // 페이징 되었을 때 마지막 페이지 번호
		
		int totalPage = (int) Math.ceil((double) totalCount / pageSize); // 총 페이지 수
		int startPage = (((pageNum - 1) / blockSize) * blockSize) + 1;
		int endPage = startPage + blockSize - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		List<BoardDto> boardDtos = boardDao.pageBoardListDao(startRow, endRow); // 모든 글을 리스트로 가져오기
		model.addAttribute("boardDtos", boardDtos);
		model.addAttribute("pageNum", pageNum); // 유저가 클릭한 페이지
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("boardCount", boardDao.allBoardCountDao()); // 모든 글 개수 전달하기
		return "pagelist";
	}
	
}
