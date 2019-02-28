package com.choolcheck;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

import javafx.scene.input.DataFormat;

@WebServlet("/ChoolCheck")
public class ChoolCheck extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		
	    MemberDTO dto = (MemberDTO)session.getAttribute("login");
	    String check = dto.getUserid();
	    ChoolCheckDTO checkDTO = service.choolCheck(check);
	    
	    
		String pattern = "yyyy년 MM월 dd일";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		Date date = new Date();
		String checkDate = dateFormat.format(date);
		
		
		String mesg = null;
		HashMap<String, String> map = new HashMap<>();
		

	if(checkDTO == null) {
			map.put("userid", check);
			map.put("timecheck", checkDate);
			service.choolInsert(map);
			session.setAttribute("checkid", map);
			mesg = checkDate+"첫번째 출석이 완료 되었습니다.";
	}else {
	
		if (check.equals(checkDTO.getUserid())) {
			if(checkDate.equals(checkDTO.getTimecheck())) {
				mesg = "이미 출석체크 하셨습니다.";
			} else {
				map.put("userid", check);
				map.put("timecheck", checkDate);
				service.choolUpdate(map);
				session.setAttribute("checkid", map);
				mesg = checkDate+(checkDTO.getCount()+1)+" 번째 출석이 완료 되었습니다.";
			}
		}
		
		if(checkDTO.getCount() == 29) {
			service.choolClear(check);
			mesg = "30일을 다 채우셨습니다. 경품 받아가세요";
		}
	}
		
		session.setAttribute("mesg", mesg);
		
		
		RequestDispatcher dis = request.getRequestDispatcher("MainServlet");
		dis.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
