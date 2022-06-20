package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.BoardMapper;
import com.multi.vo.BoardVO;

@Service
public class BoardBiz implements Biz<Integer, BoardVO> {

	@Autowired
	BoardMapper dao;

	@Override
	public void register(BoardVO v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void modify(BoardVO v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public BoardVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<BoardVO> get() throws Exception {
		return dao.selectall();
	}



}
