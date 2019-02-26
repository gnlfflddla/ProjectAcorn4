package com.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ProductOrderDTO;
import com.service.ProductCartService;


@WebServlet("/ProductCartOrderDoneServlet")
public class ProductCartOrderDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = "admin";
		
		String pCode = request.getParameter("pCode");
		String pName = request.getParameter("pName");
		String pPrice = request.getParameter("pPrice");
		String pSize = request.getParameter("pSize");
		String pColor = request.getParameter("pColor");
		String pAmount = request.getParameter("pAmount");
		String pImage = request.getParameter("pImage");
		String orderName = request.getParameter("orderName");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String payMethod = request.getParameter("payMethod");
		String orderNum = request.getParameter("orderNum");
		
		
		
		ProductOrderDTO dto = new ProductOrderDTO(0, userid, pCode, pName, Integer.parseInt(pPrice), pSize, pColor,
			 Integer.parseInt(pAmount), pImage, orderName, post, addr1, addr2, phone,
			 payMethod, null);
	
		
		ProductCartService service = new ProductCartService();
		int n = service.ProductOrderDone(dto,orderNum);
		
		HttpSession session = request.getSession();
		session.setAttribute("ProductOrderDTO", dto);

		
		response.sendRedirect("productOrderDone.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
