package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.OrderdMapper;
import com.multi.vo.OrderdVO;
@Service
public class OrderdBiz implements Biz<Integer,OrderdVO>{
	@Autowired
	OrderdMapper dao;
	
	@Override
	public void register(OrderdVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(OrderdVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public OrderdVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<OrderdVO> get() throws Exception {
		return dao.selectall();
	}
	
	public void sumTotalprice(int k) throws Exception {
		dao.updatetotalprice(k);
	}
	
}
