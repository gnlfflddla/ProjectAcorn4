package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.ProductDAO;
import com.dto.ProductDTO;
import com.dto.ProductInfoDTO;

public class ProductService {
	
	// 상품등록
	public int ProductAdd(ProductDTO dto) {
		SqlSession session = new MySqlSessionFactory().getSession();
		int n = 0;
		try {
			ProductDAO dao = new ProductDAO();
			n = dao.ProductAdd(session, dto);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	  }
	
	// 상품 목록
	public List<ProductDTO> ProductList(){
		SqlSession session = new MySqlSessionFactory().getSession();
		List<ProductDTO> list = null;
		try {
			ProductDAO dao = new ProductDAO();
			list = dao.ProductList(session);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	// 상품 색상, 사이즈 목록
	public List<ProductDTO> ProductinfoList(){
		SqlSession session = new MySqlSessionFactory().getSession();
		List<ProductDTO> list2 = null;
		try {
			ProductDAO dao = new ProductDAO();
			list2 = dao.ProductinfoList(session);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list2;
	}
	
	// 상품 상세 목록
	public ProductDTO ProductDetailList(String pCode){
		SqlSession session = new MySqlSessionFactory().getSession();
		ProductDTO list = null;
		try {
			ProductDAO dao = new ProductDAO();
			list = dao.ProductDetailList(session, pCode);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
	// 상품 색상 목록
	public List<String> pColorList(String pCode) {
		SqlSession session = new MySqlSessionFactory().getSession();
		List<String> pColorList = null;
		try {
			ProductDAO dao = new ProductDAO();
			pColorList = dao.pColorList(session, pCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pColorList;
	}
	
	// 상품 사이즈 목록
	public List<String> pSizeList(String pCode) {
		SqlSession session = new MySqlSessionFactory().getSession();
		List<String> pSizeList = null;
		try {
			ProductDAO dao = new ProductDAO();
			pSizeList = dao.pSizeList(session, pCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pSizeList;
	}
	
	// 상품 구매 횟수 
	public int OrderQuantity(String pCode) {
		SqlSession session = new MySqlSessionFactory().getSession();
		int result=0;
		try {
			ProductDAO dao = new ProductDAO();
			result = dao.OrderQuantity(session, pCode);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return result;
	}
	

}
