package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.AddrlistVO;
import com.multi.vo.CustVO;

@Repository
@Mapper
public interface CustMapper {
	public void insert(CustVO v) throws Exception;
	public void delete(String k) throws Exception;
	public void update(CustVO v) throws Exception;
	public CustVO select(String k) throws Exception;
	public List<CustVO> selectall() throws Exception;
	public void updateDefShipAddr(CustVO v) throws Exception;
	public AddrlistVO selectAsAddrlistVO(String k) throws Exception;
}
