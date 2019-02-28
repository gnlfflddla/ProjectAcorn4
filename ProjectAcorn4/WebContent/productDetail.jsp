<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<h1>상품 정보</h1>
<body>
<div align=right><jsp:include page="common/top.jsp"></jsp:include></div>
<div><jsp:include page="common/logo.jsp"></jsp:include></div>
<jsp:include page="/product/productDetail.jsp" flush="true"/>
</body>
</html>