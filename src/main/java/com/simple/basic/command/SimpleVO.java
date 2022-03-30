package com.simple.basic.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleVO {
//spring boot 에서는 vo를 표기할때 wrapper로 선언한다
	
	 private int a;//정수형
	 private String first;//문자형
	 private String last; 
	 private LocalDateTime regdate;//날짜형
	 
	 
}
