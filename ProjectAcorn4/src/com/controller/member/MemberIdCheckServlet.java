package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;


@WebServlet("/MemberIdCheckServlet")
public class MemberIdCheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println(userid);
		
		MemberService service = new MemberService();
		int count = service.idCheck(userid);
		String mesg = "사용가능한아이디입니다.";
		if(count==1) {
		  mesg = userid+"는 이미 사용중인 아이디 입니다.";	
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(mesg);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
