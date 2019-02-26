package com.controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.ProductCartDTO;
import com.dto.ProductOrderDTO;
import com.service.ProductCartService;

@WebServlet("/ProductCartOrderAllDoneServlet")
public class ProductCartOrderAllDoneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = "admin";
		
		String [] nums = request.getParameterValues("num");
		List<String> list = Arrays.asList(nums);
		
		String orderName = request.getParameter("orderName");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String payMethod = request.getParameter("payMethod");
		
		ProductCartService service = new ProductCartService();
		List<ProductCartDTO> cList = service.ProductCartOrderAllList(list);
		
		List<ProductOrderDTO> oList = new ArrayList<>();
		
		for(ProductCartDTO cDTO : cList) {
			ProductOrderDTO oDTO = new ProductOrderDTO();
			oDTO.setUserid(userid);
			oDTO.setNum(cDTO.getNum());
			oDTO.setpCode(cDTO.getpCode());
			oDTO.setpName(cDTO.getpName());
			oDTO.setpPrice(cDTO.getpPrice());
			oDTO.setpAmount(cDTO.getpAmount());
			oDTO.setpSize(cDTO.getpSize());
			oDTO.setpImage(cDTO.getpImage());
			oDTO.setpColor(cDTO.getpColor());
			oDTO.setOrderName(orderName);
			oDTO.setPost(post);
			oDTO.setAddr1(addr1);
			oDTO.setAddr2(addr2);
			oDTO.setPhone(phone);
			oDTO.setPayMethod(payMethod);
			oList.add(oDTO);			
		}
		
		int n = service.ProductOrderAllDone(oList, list);
		request.setAttribute("orderAllDone", oList);
		
		RequestDispatcher dis = request.getRequestDispatcher("productOrderAllDone.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
