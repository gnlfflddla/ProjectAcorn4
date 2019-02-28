package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Authenication_numberServlet")
public class Authenication_numberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String A_num = request.getParameter("A_num");
		
		
		HttpSession session=request.getSession();
		
		String authenication_num=(String)session.getAttribute("authenication_num");
		
		if (A_num == null) {
			
			char[] authenication_num2 = new char[10];

			for (int i = 0; i < 10; i++) {
				authenication_num2[i] = (char) (48 + (int) (Math.random() * 10));

			}

			authenication_num = new String(authenication_num2);
			System.out.println(authenication_num);
			
			request.setAttribute("mailTo",email);
			session.setAttribute("authenication_num", authenication_num);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("SendMailServlet2");
			dis.forward(request, response);

		} else {

			String mesg = "";
			if (A_num.trim().equals(authenication_num.trim())==true) {
				mesg = "인증이완료되었습니다.";
			}else {
				mesg="인증번호를 확인해주세요.";
			}
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(mesg);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
