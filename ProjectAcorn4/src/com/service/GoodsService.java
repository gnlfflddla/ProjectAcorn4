package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDao;
import com.dto.GoodsDTO;
import com.dto.PagingDTO;

public class GoodsService {

	private GoodsDao dao;
	
	public GoodsService() {
		dao = new GoodsDao();
	}
	
	public List<GoodsDTO> GoodsSelect(String gcategory, int curPage) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		
		try {
			list = dao.GoodsSelect(session,gcategory,curPage);
		} finally {
			session.close();
		}
		return list;
	}
	
	public List<GoodsDTO> SangseList (String gcode) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.SangseList(session,gcode);
		} finally {
			session.close();
		}
		return list;
	}
	
	public PagingDTO pagingSelect (String gcategory, int curPage) {
		SqlSession session = MySqlSessionFactory.getSession();
		PagingDTO dto = null;
		try {
			dto = dao.pagingSelect(session,gcategory,curPage);
		} finally {
			session.close();
		}
		return dto;
	}
	
	public List<GoodsDTO> mainselect (String gcategory) {
		SqlSession session = MySqlSessionFactory.getSession();
		List<GoodsDTO> list = null;
		try {
			list = dao.mainselect(session,gcategory);
		} finally {
			session.close();
		}
		return list;
	}
}
