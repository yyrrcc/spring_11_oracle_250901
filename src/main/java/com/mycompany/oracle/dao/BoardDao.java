package com.mycompany.oracle.dao;

import java.util.List;

import com.mycompany.oracle.dto.BoardDto;

public interface BoardDao {
	
	// 게시판 글쓰기 메서드
	public void boardWriteDao(String btitle, String bcontent, String bwriter);
	// 게시판 모든 글 목록 보기
	public List<BoardDto> boardListDao();
	// 모든 글 개수 
	public int allBoardCountDao();
	// 글 삭제
	public void boardDelete(String bnum);
	// 글 내용 확인하기
	public BoardDto boardView(String bnum);
	// 조회수 올리기
	public void updateHit(String bnum);

}
