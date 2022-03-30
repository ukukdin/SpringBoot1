package com.simple.basic.memo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.basic.command.MemoVO;

@Service("memoService")
public class MemoServiceImpl implements MemoService {

	@Autowired
	private MemoMapper memoMapper;
	
	
	@Override
	public int regist(MemoVO vo) {
		// TODO Auto-generated method stub
		return memoMapper.regist(vo);
	}


	@Override
	public ArrayList<MemoVO> getTime() {
		// TODO Auto-generated method stub
		return memoMapper.getTime();
	}

	
	
	
}
