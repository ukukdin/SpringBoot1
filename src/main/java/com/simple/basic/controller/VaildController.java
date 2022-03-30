package com.simple.basic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.validVO;

@Controller
@RequestMapping("/valid")
public class VaildController {

	//화면처리
	@GetMapping("/view")
	public void view() {
		
	}
	//유해성 검증 작업 수행시 @Valid어노테이션, validation 패키지의 Errors인터페이스를 같이선언 
	@PostMapping("/viewForm")
	public String viewForm(@Valid validVO vo, Errors erros,Model model) {
		
		if(erros.hasErrors()) {//유효성 검사에 실패한 결과가 있다면 true
//			System.out.println("유효성 검사 실패");
		//1.유효성 검사에 실패한 필드목록 확인
		List<FieldError>list=erros.getFieldErrors();		
		//2.반복문
		for(FieldError err : list) {
			System.out.println(err.getField());//유효성 검사에 실패한 변수명확인
			System.out.println(err.getDefaultMessage());//유효성 검사에 실패했을때 변수의 에러 메시지
			System.out.println(err.isBindingFailure());//유효성 검사에 바인딩 안된
		
			if(err.isBindingFailure()) {//유효성 검사는 성공했으나, 자바측에서 에러가 난경우(ex: Integer 가 문자로 들어올때)
				
			}else {//유효성 검사에 실패한경우
		//모델에 메시지를 담음
				model.addAttribute("valid_"+err.getField(), err.getDefaultMessage());
				//변수가 가지고 있는 에러메시지를 지정
			}
		
		
		}//end
		//화면에 입력데이터를 유지하기 위해 ㅡmodel에 저장
		model.addAttribute("vo",vo);
		
		return "valid/view";
		}//if
		return "redirect:/valid/result";//결과화면으로 리다이렉트
	}
	
	@GetMapping("result")
	public void result() {
		
	}
}
