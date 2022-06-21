package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.AddrlistVO;

@Repository
@Mapper
public interface AddrlistMapper {

	public void insert(AddrlistVO obj) throws Exception;
	public void delete(int obj) throws Exception;
	public void update(AddrlistVO obj) throws Exception;
	public AddrlistVO select(int obj) throws Exception;
	public List<AddrlistVO> selectall() throws Exception;
	
}
