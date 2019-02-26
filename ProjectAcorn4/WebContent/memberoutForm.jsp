<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- <%
MemberDTO dto=(MemberDTO)session.getAttribute("login");
System.out.println(dto);
%> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원탈퇴가 완료되었습니다.</h1>
<a href="MainServlet">메인으로 돌아가기</a>
</body>
</html>