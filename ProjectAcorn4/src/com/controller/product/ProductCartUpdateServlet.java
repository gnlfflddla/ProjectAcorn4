package com.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@WebServlet("/ProductCartUpdateServlet")
public class ProductCartUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");
		String pAmount = request.getParameter("pAmount");

		ProductCartService service = new ProductCartService();
		ProductCartDTO dto = new ProductCartDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setpAmount(Integer.parseInt(pAmount));
		
		int result = service.ProductCartUpdate(dto);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
