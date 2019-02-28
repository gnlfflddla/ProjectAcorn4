package com.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.PagingDTO;

public class GoodsDao {

	public List<GoodsDTO> GoodsSelect (SqlSession session,String gcategory,int curPage) {
		PagingDTO pDto = new PagingDTO();
		int offset = (curPage -1) * pDto.getPerPage();
		
		List<GoodsDTO> list = session.selectList("GoodsMapper.GoodsSelect",gcategory,
				new RowBounds(offset,pDto.getPerPage()));
		
		pDto.setCurPage(curPage);
		pDto.setList(list);
		pDto.setTotalCount(TotalCount(session,gcategory));
		return list;
	}
	
	public List<GoodsDTO> SangseList (SqlSession session,String gcode) {
		return session.selectList("GoodsMapper.SangseList",gcode);
	}
	
	public PagingDTO pagingSelect (SqlSession session,String gcategory, int curPage) {
		PagingDTO pDto = new PagingDTO();
		int offset = (curPage -1) * pDto.getPerPage();
		
		List<GoodsDTO> list = session.selectList("GoodsMapper.pagingSelect",gcategory,
				new RowBounds(offset,pDto.getPerPage()));
		
		
		pDto.setCurPage(curPage);
		pDto.setList(list);
		pDto.setTotalCount(TotalCount(session, gcategory));
		
		return pDto;
	}
	
	
	public int TotalCount (SqlSession session, String gcategory) {
		return session.selectOne("GoodsMapper.totalCount",gcategory);
	}
	
	public List<GoodsDTO> mainselect (SqlSession session,String gcategory){
		return session.selectList("GoodsMapper.mainselect", gcategory);
	}
}
