package com.mycompany.oracle.dao;

public interface BoardDao {
	
	// 게시판 글쓰기 메서드
	public void boardWriteDao(String btitle, String bcontent, String bwriter);

}
