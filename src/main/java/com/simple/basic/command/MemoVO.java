package com.simple.basic.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoVO {


	
	private int mno;
	@NotBlank
	@Pattern(regexp =".{5,}$", message ="5글자 이상의 내용을 입력하세요")
	private String memo;
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message="000-0000-0000 식으로 입력부탁드립니다.")
	private String phone;
	@Pattern(regexp= "[0-9]{4}", message="공백없이 숫자 4개")
	private String pw;
	@NotNull(message= "선택하셔야합니다.")
	private String secret;
	
}
