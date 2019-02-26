<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 화면입니다.</h1>
<jsp:include page="member/mypage.jsp"/>
<button><a href="MainServlet">메인으로 돌아가기</a></button>
<button><a href="WithdrawalUIServlet">회원탈퇴</a></button>
</body>
</html>