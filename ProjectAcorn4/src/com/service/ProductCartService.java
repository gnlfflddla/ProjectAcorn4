package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.ProductCartDAO;
import com.dto.ProductCartDTO;
import com.dto.ProductOrderDTO;

public class ProductCartService {

	// 장바구니 상품등록
	public int ProductCartAdd(ProductCartDTO dto) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		int result=0;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			result = dao.ProductCartAdd(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}
	
	// 장바구니 목록
	public List<ProductCartDTO> ProductCartList(){
	
		SqlSession session = MySqlSessionFactory.getSession();
		List<ProductCartDTO> list = null;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			list = dao.ProductCartList(session);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	// 장바구니 상품 삭제
	public int ProductCartDel(int num) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		int result = 0;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			result = dao.ProductCartDel(session, num);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}
	
	// 장바구니 수량 수정
	public int ProductCartUpdate(ProductCartDTO dto) {
		
		SqlSession session = MySqlSessionFactory.getSession();
		int result = 0;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			result = dao.ProductCartUpdate(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}
	
	// 상품 선택 삭제
	public int ProductCartAllDel(List<String> list){
		SqlSession session = MySqlSessionFactory.getSession();
		int result = 0;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			result = dao.ProductCartAllDel(session, list);
			session.commit();
		}finally {
			session.close();
		}
		return result;
	}
	
	// 상품 구매 .. 장바구니 목록
	public List<ProductCartDTO> ProductCartOrderList(ProductCartDTO dto){
		SqlSession session = MySqlSessionFactory.getSession();
		List<ProductCartDTO> list = null;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			list = dao.ProductCartOrderList(session, dto);
		}finally {
			session.close();
		}
		return list;
	}
	
	// 상품 구매
	public int ProductOrderDone(ProductOrderDTO dto, String orderNum){
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			n = dao.ProductOrderDone(session, dto);
			n = dao.ProductCartDel(session, Integer.parseInt(orderNum));
			session.commit();
		}catch(Exception e) {
			session.rollback(); // 하나라도 실패하면
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	// 상품 전체 구매 .. 목록
	public List<ProductCartDTO> ProductCartOrderAllList(List<String> data){
		SqlSession session = MySqlSessionFactory.getSession();
		List<ProductCartDTO> list = null;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			list = dao.ProductCartOrderAllList(session, data);
		}catch(Exception e) {
		  e.printStackTrace();	
		}finally {
			session.close();
		}
		return list;
	}
	
	// 상품 전체 구매
	public int ProductOrderAllDone(List<ProductOrderDTO> x, List<String> nums){
		SqlSession session = MySqlSessionFactory.getSession();
		int n = 0;
		try {
			ProductCartDAO dao = new ProductCartDAO();
			n = dao.ProductOrderAllDone(session, x);
			n = dao.ProductCartAllDel(session, nums);
			session.commit();
		}catch(Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
		return n;
	}
	
}
