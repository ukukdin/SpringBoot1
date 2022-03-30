package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.MemoMapper;
import com.simple.basic.memo.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	@Qualifier("memoService")
	private MemoService memoService;
	
	
	
	@GetMapping("/memoWrite")
	public void memoWrite() {
		
	}
	@PostMapping("/MemoForm")
	public String MemoForm(@Valid MemoVO vo,Errors erros, Model model) {
		
		if(erros.hasErrors()) {
			List<FieldError>list=erros.getFieldErrors();
			
			for(FieldError err:list) {
				System.out.println(err.getField());
				System.out.println(err.getDefaultMessage());
				System.out.println(err.isBindingFailure());
			
				if(err.isBindingFailure()) {
					
				}else {
					model.addAttribute("valid_"+err.getField(), err.getDefaultMessage());
					
				}
			}
			model.addAttribute("vo",vo);
			return "/memo/memoWrite";
		}
		
		int result= memoService.regist(vo);
		System.out.println(result);
		return "redirect:/memo/memoList";
	}
	@GetMapping("/memoList")
	public String memoList(MemoVO vo,Model model) {
		
		ArrayList<MemoVO> list= memoService.getTime();
		
		model.addAttribute("list",list);
		
		return "/memo/memoList";
	}
	
}
