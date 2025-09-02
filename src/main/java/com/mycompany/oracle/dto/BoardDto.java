package com.mycompany.oracle.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	
	private int bnum; // 기본키
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bhit;
	private Timestamp bdate;
	
	// BoardDto는 MemberDto와 1:1 관계
	private MemberDto memberDto;
	
	// Oracle db에서 만든 rownum 값 필드
	private int rnum;
}
