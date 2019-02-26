package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ProductCartDTO;
import com.dto.ProductOrderDTO;

public class ProductCartDAO {

	// 장바구니 상품 등록
	public int ProductCartAdd(SqlSession session, ProductCartDTO dto) {
		int result = session.insert("ProductCartMapper.ProductCartAdd",dto);
		return result;
	}
	
	// 장바구니 목록
	public List<ProductCartDTO> ProductCartList(SqlSession session){
		List<ProductCartDTO> list = session.selectList("ProductCartMapper.ProductCartList");
		return list;
	}
	
	// 장바구니 상품 삭제
	public int ProductCartDel(SqlSession session, int num) {
		int result = session.delete("ProductCartMapper.ProductCartDel",num);
		return result;
	}
	
	// 장바구니 수량 수정
	public int ProductCartUpdate(SqlSession session, ProductCartDTO dto) {
		int result = session.update("ProductCartMapper.ProductCartUpdate",dto);
		return result;
	}
	
	// 상품 선택 삭제
	public int ProductCartAllDel(SqlSession session, List<String> list) {
		int result = session.delete("ProductCartMapper.ProductCartAllDel",list);
		return result;
	}
	
	// 상품 구매 .. 장바구니 목록
	public List<ProductCartDTO> ProductCartOrderList(SqlSession session, ProductCartDTO dto){
		List<ProductCartDTO> list = session.selectList("ProductCartMapper.ProductCartOrderList",dto);
		return list;
	}
	
	// 상품 구매
	public int ProductOrderDone(SqlSession session, ProductOrderDTO dto) {
		int n = session.insert("ProductCartMapper.ProductOrderDone",dto);
		return n;
	}
	
	// 상품 전체 구매 .. 목록
	public List<ProductCartDTO> ProductCartOrderAllList(SqlSession session, List<String>data){
		List<ProductCartDTO> list = session.selectList("ProductCartMapper.ProductCartOrderAllList",data);
		return list;
	}
	
	// 상품 전체 구매
	public int ProductOrderAllDone(SqlSession session, List<ProductOrderDTO> x) {
		int n = session.insert("ProductCartMapper.ProductOrderAllDone",x);
		return n;
	}
}
