package com.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ProductDTO;
import com.dto.ProductInfoDTO;
import com.service.ProductService;
@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCode = request.getParameter("pCode");
		
		ProductService service = new ProductService();
		ProductDTO dto = new ProductDTO();
		dto = service.ProductDetailList(pCode);

		List<String> pColorList = service.pColorList(pCode);
		List<String> pSizeList = service.pSizeList(pCode);
		
		int result = service.OrderQuantity(pCode);
		
		request.setAttribute("ProductDetail", dto);
		request.setAttribute("pColorList", pColorList);
		request.setAttribute("pSizeList", pSizeList);
		
		HttpSession session = request.getSession();
		session.setAttribute("OrderQuantity", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("productDetail.jsp");
		dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
