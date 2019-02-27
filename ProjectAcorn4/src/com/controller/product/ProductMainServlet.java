package com.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductDTO;
import com.service.ProductService;
@WebServlet("/ProductMainServlet")
public class ProductMainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductService service = new ProductService();
		
		// 상품 목록
		List<ProductDTO> list = service.ProductList();
		
		// 상품 색상,사이즈 목록
		List<ProductDTO> list2 = service.ProductinfoList();
		
		request.setAttribute("productList", list);
		request.setAttribute("productinfoList", list2);
		
		RequestDispatcher dis = request.getRequestDispatcher("productMain.jsp");
		dis.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
