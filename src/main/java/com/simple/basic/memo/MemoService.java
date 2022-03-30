package com.simple.basic.memo;

import java.util.ArrayList;

import com.simple.basic.command.MemoVO;

public interface MemoService {


	
	public ArrayList<MemoVO> getTime();
	
	public int regist(MemoVO vo);
	
}
