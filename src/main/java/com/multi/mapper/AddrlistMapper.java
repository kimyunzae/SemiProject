package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.AddrlistVO;

@Repository
@Mapper
public interface AddrlistMapper {

	public void insert(AddrlistVO v) throws Exception;
	public void delete(int k) throws Exception;
	public void update(AddrlistVO v) throws Exception;
	public AddrlistVO select(int k) throws Exception;
	public List<AddrlistVO> selectall() throws Exception;
	public List<AddrlistVO> selectpercust(String uid) throws Exception;
}
