<%@page import="com.dto.MemberDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href=MainServlet>
	<img alt="daemoon" src="images/dae.jpg">
	</a>
<h1>회원가입 화면입니다.</h1>

<jsp:include page="member/memberForm.jsp"/>
</body>
</html>