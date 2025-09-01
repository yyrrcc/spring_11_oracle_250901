package com.mycompany.oracle.dao;

public interface MemberDao {
	
	// 회원가입 메서드
	public int memberJoinDao(String memberid, String memberpw, String membername);
	
	// 아이디 중복 검사 메서드
	public int memberidCheckDao(String memberid);
	
	// 로그인
	public int memberLoginDao(String memberid, String memberpw);

}
