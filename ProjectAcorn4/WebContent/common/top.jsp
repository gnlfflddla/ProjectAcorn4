<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
MemberDTO dto=(MemberDTO)session.getAttribute("login");
if(dto!=null){
%>
환영합니다.<%=dto.getUsername() %>님
<a href="LogoutServlet"><button>로그아웃</button></a>
<a href="MyPageServlet"><button>마이페이지</button></a>
<%
}else{
%>
<a href="LoginUIServlet"><button>로그인</button></a>
<a href="AgreementUIServlet"><button>회원가입</button></a><br>
<jsp:include page="search.jsp" flush="true"/> 
<%
}
%>