package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.OrderdetailVO;

@Repository
@Mapper
public interface OrderdetailMapper {
	public void insert(OrderdetailVO obj) throws Exception;
	public void delete(int obj) throws Exception;
	public void update(OrderdetailVO obj) throws Exception;
	public OrderdetailVO select(int obj) throws Exception;
	public List<OrderdetailVO> selectall() throws Exception;
}
