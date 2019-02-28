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


@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberDTO dto=(MemberDTO)session.getAttribute("login");
		
		String nextPage="";
		
		if(dto!=null) {
		String userid=dto.getUserid();
		String username=dto.getUsername();
		String birthday=request.getParameter("birthday");
		String passwd=request.getParameter("passwd");
		String post=request.getParameter("post");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String [] phone1=request.getParameterValues("phone");
		String email=request.getParameter("email");
		String gradeno=dto.getGradeno();
		String reception=dto.getReception();
		
		String phone=phone1[0]+phone1[1]+phone1[2];
		
		MemberDTO dto2=new MemberDTO(userid, passwd, username, birthday, post, 
					addr1, addr2, phone, email, gradeno, reception);
		
		MemberService service=new MemberService();
		int n=service.update(dto2);
		
		nextPage="MainServlet";
		session.setAttribute("login", dto2);
		session.setAttribute("mesg", "수정이 완료되었습니다.");
		}else {
			nextPage="LoginUIServlet";
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
