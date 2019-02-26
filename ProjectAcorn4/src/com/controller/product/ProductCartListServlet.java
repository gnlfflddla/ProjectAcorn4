package com.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@WebServlet("/ProductCartListServlet")
public class ProductCartListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductCartService service = new ProductCartService();
		List<ProductCartDTO> list = service.ProductCartList();
		
		request.setAttribute("ProductCartList", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("productCartList.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
