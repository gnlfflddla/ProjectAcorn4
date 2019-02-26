package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;


@WebServlet("/MemberIdSearchServlet")
public class MemberIdSearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username").trim();
		String phone1=request.getParameter("phone1").trim();
		String phone2=request.getParameter("phone2").trim();
		String phone3=request.getParameter("phone3").trim();
		String email1=request.getParameter("email1").trim();
		String email2=request.getParameter("email2").trim();
		
		MemberDTO dto=new MemberDTO();
		dto.setUsername(username);
		dto.setPhone1(phone1);
		dto.setPhone2(phone2);
		dto.setPhone3(phone3);
		dto.setEmail1(email1);
		dto.setEmail2(email2);
		
		MemberService service=new MemberService();
		HashMap<String, String> map=service.idSearch(dto);
		
		String nextPage=null;
		
		
		
		if(map==null) {
			nextPage="MemberIdSearchUIServlet";
			request.setAttribute("mesg", "입력하신 정보로 가입 된 회원 아이디는 존재하지 않습니다.");
		}else {
			
			String userid=map.get("USERID"); //전체 아이디 
			String userid1=map.get("USERID1"); //뒷자리 가린 아이디
			
			nextPage="SendMailServlet";
			request.setAttribute("mailTo", email1+"@"+email2);
			request.setAttribute("username", username);
			request.setAttribute("userid", userid);
			request.setAttribute("userid1", userid1);
			
		}
		
		RequestDispatcher dis=request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
