package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.GoodsDTO;
import com.dto.PagingDTO;
import com.service.GoodsService;

@WebServlet("/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String gcategory = request.getParameter("gcategory");
		String curPage = request.getParameter("curPage");
		
		
		if (curPage == null) {
			curPage = "1";
		}
		
		
		GoodsService service = new GoodsService();
		List<GoodsDTO> list = service.GoodsSelect(gcategory,Integer.parseInt(curPage));
		
		PagingDTO dto = service.pagingSelect(gcategory,Integer.parseInt(curPage));
		
		List<GoodsDTO> pagingList = dto.getList();
		
		int perPage = dto.getPerPage();
		
		int totalCount = dto.getTotalCount();
		
		int perBlock = dto.getPerBlock();
		
		int totalPage = totalCount / perPage;
		if (totalCount%perPage != 0) totalPage++;
		
		int curBlock = (int)Math.ceil((double) Integer.parseInt(curPage) / perBlock);
		
		int startPage = (curBlock -1 ) * perBlock + 1;
		
		int endPage = startPage + perBlock -1;
		if (endPage > totalPage) endPage = totalPage;
		GoodsDTO gdto = new GoodsDTO();
		HttpSession session = request.getSession();
		session.setAttribute("pagingList", pagingList);
		session.setAttribute("perPage", perPage);
		session.setAttribute("totalCount", totalCount);
		session.setAttribute("perBlock", perBlock);
		session.setAttribute("totalPage", totalPage);
		session.setAttribute("curBlock", curBlock);
		session.setAttribute("curPage", curPage);
		session.setAttribute("startPage", startPage);
		session.setAttribute("endPage", endPage);
		session.setAttribute("gcategory", gcategory);
		session.setAttribute("gImage", gdto.getgImage());
		
		session.setAttribute("Goodslist", list);

		request.getRequestDispatcher("sangpum.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
