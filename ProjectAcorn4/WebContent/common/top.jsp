<%@page import="com.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="css/css.css">
<p class = "font">
<!-- 여기 껍데기로 보내기 빼고 바로 jsp로 보냈음 -->
<c:choose>
	<c:when test="${login != null }">
		<a href="LogoutServlet" >로그아웃</a>&nbsp;&nbsp;
		<a href="">나의정보</a>&nbsp;&nbsp;
		<a href="ChoolCheck">출석체크</a>&nbsp;&nbsp;
		<a href="ProductCartListServlet">장바구니</a>&nbsp;&nbsp;
	</c:when>

	<c:otherwise>
		<a href="LoginUIServlet">로그인</a>&nbsp;&nbsp;
		<a href="AgreementUIServlet">회원가입</a>&nbsp;&nbsp;
	</c:otherwise>
</c:choose>
<a href="list.do">게시판</a>&nbsp;&nbsp;

</p>