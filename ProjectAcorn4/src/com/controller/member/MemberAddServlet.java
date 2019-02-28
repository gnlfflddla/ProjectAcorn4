package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MemberAddServlet")
public class MemberAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String userid=request.getParameter("userid");
		String passwd=request.getParameter("passwd");
		String username=request.getParameter("username");
		String birthday=request.getParameter("birthday");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String[] phone1=request.getParameterValues("phone");
		String email=request.getParameter("email");
		String gradeno="silver";
		String reception=(String)session.getAttribute("reception");
		
		String phone=phone1[0]+phone1[1]+phone1[2];
		
		MemberDTO dto=new MemberDTO(userid, passwd, username, birthday, 
					post, addr1, addr2, phone, email, gradeno, reception);
		
		System.out.println(dto);
		
		MemberService service=new MemberService();
		
		int n=service.memberAdd(dto);
		
		if(n!=0) {
			session.setAttribute("mesg", "회원가입성공");
		}
		
		response.sendRedirect("MainServlet");	
	
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
