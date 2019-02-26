package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resources;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/WithdrawalServlet")
public class WithdrawalServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		
		String userid=dto.getUserid();
		String passwd=request.getParameter("passwd");
		
		HashMap<String, String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		MemberService service=new MemberService();
		int n=service.withdrawal(map);
		
		String nextPage="";
		
		if(n==1) {
			nextPage="memberoutForm.jsp";
			session.invalidate();
		}else {
			nextPage="WithdrawalUIServlet";
			session.setAttribute("mesg", "비밀번호를 확인해주세요.");
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
