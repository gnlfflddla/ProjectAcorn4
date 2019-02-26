package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ProductDTO;
import com.dto.ProductInfoDTO;

public class ProductDAO {

	// 상품 등록
	public int ProductAdd(SqlSession session, ProductDTO dto) {
		int n=0;
		n = session.insert("ProductMapper.ProductAdd",dto);			
		for(int i=0; i<dto.getpColor().size(); i++) {
			  for(int j=0; j<dto.getpSize().size(); j++) {
				  ProductInfoDTO pdto = new ProductInfoDTO();
				  pdto.setpCode(dto.getpCode());
				  pdto.setpColor(dto.getpColor().get(i));
				  pdto.setpSize(dto.getpSize().get(j));
			  n = session.insert("ProductMapper.ProductAdd2",pdto);
			  }
			}	
		return n;
	}
	
	// 상품 목록 
	public List<ProductDTO> ProductList(SqlSession session){
		List<ProductDTO> list = session.selectList("ProductMapper.ProductList");
		return list;
	}
	
	// 상품 색상,사이즈 목록
	public List<ProductDTO> ProductinfoList(SqlSession session){
		List<ProductDTO> list2 = session.selectList("ProductMapper.ProductinfoList");
		return list2;
	}
	
	// 상품 상세 목록 .. Product
	public ProductDTO ProductDetailList(SqlSession session, String pCode){
		ProductDTO list = session.selectOne("ProductMapper.ProductDetailList",pCode);
		return list;
	}
	
	// 상품 색상 목록
	public List<String> pColorList(SqlSession session, String pCode){
		List<String> pColorList = session.selectList("ProductMapper.pColorList",pCode);
		return pColorList;
	}
	
	// 상품 사이즈 목록
	public List<String> pSizeList(SqlSession session, String pCode){
		List<String> pSizeList = session.selectList("ProductMapper.pSizeList",pCode);
		return pSizeList;
	}
	
	// 상품 구매 횟수
	public int OrderQuantity(SqlSession session, String pCode) {
		int result = session.selectOne("ProductMapper.OrderQuantity",pCode);
		return result;
	}
	
}
