package com.controller.member;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;
import com.sms.SendSMS;

@WebServlet("/MemberPW_phoneSearchServlet")
public class MemberPW_phoneSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String nextPage = "";

		HashMap<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("username", username);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);

		MemberService service = new MemberService();
		int n = service.pwSearch_phone(map);

		if (n == 1) {
			char[] passwd2 = new char[10];

			for (int i = 0; i < 10; i++) {
				if (i % 2 == 0)
					passwd2[i] = (char) (48 + (int) (Math.random() * 10));
				else
					passwd2[i] = (char) (65 + (int) (Math.random() * 26));
			}

			String passwd = new String(passwd2);

			HashMap<String, String> map2 = new HashMap<>();
			map2.put("userid", userid);
			map2.put("passwd", passwd);

			MemberService service2 = new MemberService();
			int n2 = service.passwdUpdate(map2);

			// 휴대폰으로 찾기
			SendSMS s = new SendSMS();
			s.sendsms(map2);
			request.setAttribute("phone1", phone1);
			request.setAttribute("phone2", phone2);
			request.setAttribute("phone3", phone3);
			nextPage = "mail/sendSMSCompletedForm.jsp";

		} else {
			nextPage = "MemberPWSearchUIServlet";
			request.setAttribute("mesg", "입력하신 정보로 가입 된 회원 아이디는 존재하지 않습니다.");
		}

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
