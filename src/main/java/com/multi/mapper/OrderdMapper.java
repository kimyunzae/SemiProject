package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.OrderdVO;

@Repository
@Mapper
public interface OrderdMapper {
	public void insert(OrderdVO obj) throws Exception;
	public void delete(int obj) throws Exception;
	public void update(OrderdVO obj) throws Exception;
	public OrderdVO select(int obj) throws Exception;
	public List<OrderdVO> selectall() throws Exception;
}
