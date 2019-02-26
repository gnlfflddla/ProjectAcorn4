package com.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductCartDTO;
import com.service.ProductCartService;

@WebServlet("/ProductCartServlet")
public class ProductCartAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = "admin";
		
		String pCode = request.getParameter("pCode");
		String pName = request.getParameter("pName");
		String pPrice = request.getParameter("pPrice");
		String pImage = request.getParameter("pImage");
		String pSize = request.getParameter("pSize");
		String pColor = request.getParameter("pColor");
		String pAmount = request.getParameter("pAmount");
		
		ProductCartDTO dto = new ProductCartDTO();
		dto.setUserid(userid);
		dto.setpCode(pCode);
		dto.setpName(pName);
		dto.setpPrice(Integer.parseInt(pPrice));
		dto.setpImage(pImage);
		dto.setpSize(pSize);
		dto.setpColor(pColor);
		dto.setpAmount(Integer.parseInt(pAmount));
		
		ProductCartService service = new ProductCartService();
		int result = service.ProductCartAdd(dto);
		
		response.sendRedirect("MainServlet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
