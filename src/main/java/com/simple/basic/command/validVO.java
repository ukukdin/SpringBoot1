package com.simple.basic.command;

import javax.validation.constraints.Email;
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
public class validVO {

	//1.스프링부트 JPA 라이브러리를 사용하면 기본타입은 null을 가질수 없기 때문에 값에 맵핑이 안됩니다.
	//그래서 wrapper형으로반드시 선언합니다.
	/*
	 * 2.유효성 검사에 필요한 멤버변수에 어노테이션 설정
	 * 사용할수 있는 어노테이션 - @Notnull : null을 허용하지않는다.(String,long 등등 적용가능)
	 * @Notblank:null,""," " 허용하지않는다. (string에 적용)
	 * @NotEmpty : null, "" 허용하지않는다.(String , array 등등에 적용가능)
	 * @Pattern : 정규표현 형식에 문자열을 정의 할수 있다.(String에 적용가능)
	 * @Email :이메일 형식만 허용
	 */
	@NotBlank(message = "이름은 공백일 수 없습니다.")//문자는 notblank
	private String name;
	@NotNull(message = "급여는 필수 입니다.")//숫자는 notnull
	private Integer salary;
	//형식 지정시
	@Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}", message="000-0000-0000 이어야합니다.")
	private String phone; 
	//동시에 사용가능
	@NotBlank
	@Email(message = "이메일 형식이어야 합니다.")//공백을허용
	private String email;
}
