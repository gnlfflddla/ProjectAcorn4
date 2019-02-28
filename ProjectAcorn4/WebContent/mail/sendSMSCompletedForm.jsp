<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../css/Form.jsp"/>
<c:set var="phone" value="${phone}" scope="session"/>

<h3>아이디/비밀번호 찾기</h3>
<span>
고객님께서 입력하신 휴대전화
${phone}로
 문자가 발송되었습니다.<br>
저희 쇼핑몰을 이용해주셔서 감사합니다.<br><br>
</span>
<a href="MainServlet"><button>확인</button></a>
<a href="LoginUIServlet"><button>로그인</button></a>

