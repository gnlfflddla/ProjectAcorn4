package com.controller.product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ProductCartService;

@WebServlet("/ProductCartAllDelServlet")
public class ProductCartAllDelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] data = request.getParameterValues("check");
		
		List<String> list = Arrays.asList(data);
				
		ProductCartService service = new ProductCartService();
		int result = service.ProductCartAllDel(list);
		
		response.sendRedirect("ProductCartListServlet");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
