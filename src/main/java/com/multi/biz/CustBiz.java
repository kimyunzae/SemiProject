package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.CustMapper;
import com.multi.vo.AddrlistVO;
import com.multi.vo.CustVO;
@Service
public class CustBiz implements Biz<String,CustVO>{
	@Autowired
	CustMapper dao;
	
	@Override
	public void register(CustVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(CustVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public CustVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<CustVO> get() throws Exception {
		return dao.selectall();
	}
	
	public void modifyDefShipAddr(CustVO v) throws Exception {
		dao.updateDefShipAddr(v);
	}
	
	public AddrlistVO getAsAddrlistVO(String k) throws Exception {
		return dao.selectAsAddrlistVO(k);
		// aid는 0으로 나옵니다 0이면 따로 처리하는걸 코딩해야 함
	}
	
}
