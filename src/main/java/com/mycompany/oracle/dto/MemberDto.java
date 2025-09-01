package com.mycompany.oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	
	private int membernum; // 기본키 + 자동증가
	private String memberid;
	private String memberpw;
	private String membername;
	private String memberdate;

}

