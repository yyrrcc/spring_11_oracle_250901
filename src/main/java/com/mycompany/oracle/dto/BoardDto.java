package com.mycompany.oracle.dto;

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
	private String bdate;
	
	// BoardDto는 MemberDto와 1:1 관계
	private MemberDto memberDto;
}
