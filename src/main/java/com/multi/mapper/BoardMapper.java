package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.BoardVO;

@Repository
@Mapper
public interface BoardMapper {

	public void insert(BoardVO obj) throws Exception;
	public void delete(int obj) throws Exception;
	public void update(BoardVO obj) throws Exception;
	public BoardVO select(int obj) throws Exception;
	public List<BoardVO> selectall() throws Exception;
}
