
package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ChoolCheckDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.dto.PagingDTO;
import com.service.GoodsService;

@WebServlet("/MainP")
public class MainP extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String curPage = (String)session.getAttribute("curPage");
		
		if(curPage!=null) {
			curPage = null;
			session.setAttribute("curPage", curPage);
		}
		
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = service.mainselect("top");
		
		
		
		session.setAttribute("Goodslist", list);
		
		
		RequestDispatcher dis =
				request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
