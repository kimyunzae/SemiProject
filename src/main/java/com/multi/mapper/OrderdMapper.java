package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.OrderdVO;

@Repository
@Mapper
public interface OrderdMapper {
	public void insert(OrderdVO v) throws Exception;
	public void delete(int k) throws Exception;
	public void update(OrderdVO v) throws Exception;
	public OrderdVO select(int k) throws Exception;
	public List<OrderdVO> selectall() throws Exception;
	public List<OrderdVO> selectod() throws Exception;	
	public List<OrderdVO> selectpi() throws Exception;
	public void updatetotalprice(int k) throws Exception;
	
	
}