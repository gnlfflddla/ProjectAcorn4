package com.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.PageDTO;
import com.dto.ProductDTO;
import com.service.ProductService;

@WebServlet("/ProductCategoryListServlet")
public class ProductListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gCategory = request.getParameter("gcategory");
		ProductService service = new ProductService();
		List<ProductDTO> list = service.productCategoryList(gCategory);
		request.setAttribute("productList", list);
		RequestDispatcher dis = request.getRequestDispatcher("mainForm.jsp");
		dis.forward(request, response);
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
