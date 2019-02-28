package com.mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {

	public void send(String title, String email, String mesg, String contant) {
		String host = "smtp.naver.com";
	    String subject = title;
	    String from = "gijunzzang@naver.com"; //보내는 메일
	   String fromName = "Acorn 쇼핑몰";
	    String to = email; //받는 메일
	    String content =  mesg +"\n"+ contant;
	    
	   try{
	     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
	     Properties props = new Properties();
	     //네이버 SMTP 사용시
	    props.put("mail.smtp.starttls.enable","true");
	     props.put("mail.transport.protocol","smtp");
	     props.put("mail.smtp.host", host);
	     
	     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
	    props.put("mail.smtp.user", from);
	     props.put("mail.smtp.auth","true");
	     props.put("mail.smtp.debug", "true");
	     props.put("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	     props.put("mail.smtp.socketFactory.fallback", "false");


	     Authenticator auth = new SendMail();
	     Session mailSession = Session.getDefaultInstance(props,auth);
	   
	     Message msg = new MimeMessage(mailSession);
	     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
	    InternetAddress[] address = {new InternetAddress(to)};
	    
	     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
	   
	     msg.setSubject(subject); //제목설정
	    msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
	    msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
	    
	     Transport.send(msg); //메일 보내기

	     }catch(MessagingException ex){
	      System.out.println("mail send error : "+ex.getMessage());
	       ex.printStackTrace();
	     }catch(Exception e){
	      System.out.println("error : "+e.getMessage());
	       e.printStackTrace();
	     }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String gradenoS = request.getParameter("gradenoS");
		String gradenoA = request.getParameter("gradenoA");
		String gradenoB = request.getParameter("gradenoB");
		String gradenoC = request.getParameter("gradenoC");
		String gradenoD = request.getParameter("gradenoD");
		
		String contents = request.getParameter("contents");
		MemberService service = new MemberService();
		List<MemberDTO> list = service.memberSelect();
		HashMap<String, String> map = new HashMap<>();
		 String mesg = null;		
		 
		for (MemberDTO x : list) {

			 if(gradenoS==null) {
				// nextPage="gradeMail.html";
				 request.setAttribute("mesg", "등급이 정해져 있지 않습니다.");
			 }else {
				// nextPage="SendMailServlet";
				 if("S급".equals(x.getGradeno())) {
					 mesg = "고객님은 S등급 회원으로써"+ gradenoS+"%할인 쿠폰을 보내드립니다";
				 } else if("A급".equals(x.getGradeno())) {
					 mesg = "고객님은 A등급 회원으로써"+ gradenoA+"%할인 쿠폰을 보내드립니다";
				 } else if("B급".equals(x.getGradeno())) {
					 mesg = "고객님은 B등급 회원으로써"+ gradenoB+"%할인 쿠폰을 보내드립니다";
				 } else if("C급".equals(x.getGradeno())) {
					 mesg = "고객님은 C등급 회원으로써"+ gradenoC+"%할인 쿠폰을 보내드립니다";
				 } else if("D급".equals(x.getGradeno())) {
					 mesg = "고객님은 D등급 회원으로써"+ gradenoD+"%할인 쿠폰을 보내드립니다";
				 }
				 
				 map.put("mailTo", x.getEmail1()+x.getEmail2());
				 map.put("title", title);
				 map.put("contents", contents);
				 map.put("gradeno", x.getGradeno());
				 map.put("mesg",mesg);
				 send(title,x.getEmail1()+x.getEmail2(), mesg, contents);
			 


			 }
		}	
			response.sendRedirect("MainP");
	 		   
	}//end doGet
		 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
