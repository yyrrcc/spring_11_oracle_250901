package com.mycompany.oracle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.oracle.dao.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping (value = "/join")
	public String join(HttpServletRequest request, Model model) {
		String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", error);
		}
		return "memberjoin";
	}
	@RequestMapping (value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int idCheck = memberDao.memberidCheckDao(mid); // 아이디 존재 여부 확인
		if (idCheck == 1) {
			model.addAttribute("msg", "이미 가입된 아이디 입니다. 다시 가입 해주세요.");
			model.addAttribute("url", "join");
			return "alert/alert";
		} else {
			memberDao.memberJoinDao(mid, mpw, mname);
			model.addAttribute("mid", mid);
			return "memberjoinOk";
		}
	}
	
	@RequestMapping (value = "/login")
	public String login(HttpServletRequest request, Model model) {
		String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", error);
		}
		return "login";
	}
	@RequestMapping (value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		int loginCheck = memberDao.memberLoginDao(mid, mpw);
		if (loginCheck == 1) {
			session.setAttribute("sessionId", mid);
			model.addAttribute("msg", "로그인 성공");
			model.addAttribute("url", "loginSuccess");
			return "alert/alert";
		} else {
			model.addAttribute("msg", "로그인 실패. 아이디 또는 비밀번호를 다시 확인하세요.");
			model.addAttribute("url", "login");
			return "alert/alert";
		}
	}
	
	@RequestMapping (value = "/loginSuccess")
	public String loginSuccess(HttpServletRequest request, Model model) {
		return "loginSuccess";
	}
}
