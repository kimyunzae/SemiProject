package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.OrderdetailMapper;
import com.multi.vo.OrderdetailVO;
@Service
public class OrderdetailBiz implements Biz<Integer,OrderdetailVO>{
	@Autowired
	OrderdetailMapper dao;
	
	@Override
	public void register(OrderdetailVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(OrderdetailVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public OrderdetailVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<OrderdetailVO> get() throws Exception {
		return dao.selectall();
	}
	
}
