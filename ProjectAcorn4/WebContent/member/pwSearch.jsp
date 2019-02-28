<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mesg" value="${mesg}" scope="session"/>
<c:if test="${empty mesg==false}">
<script type="text/javascript">   
alert('${mesg}');
</script>
</c:if>
<c:remove var="mesg" scope="session"/>
  
<jsp:include page="../css/Form.jsp"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#A").on("click",function(){
			$("#a").show();
			$("#b").hide();
		});
		$("#B").on("click",function(){
			$("#b").show();
			$("#a").hide();
		});
		
		//이메일 선택
		 $("#emailSelect").on("change",function(){
			 var email=$("#email").val();
			 var email1=$(this).val();
			
			if(email.includes("@")==true){
				$("#email").val(email+email1);
			}else{
				$("#email").val(email+"@"+email1);
			}
		 });
	});

</script>
<div>
   <b>이메일로 찾기<input type="radio" id="A" name="radio" checked></b>
   <b>휴대폰으로 찾기 <input type="radio" id="B" name="radio"></b>
    
</div>
<div id="a">
<form action="MemberPW_emailSearchServlet" method="post">
<table border='2'>
<tr>
<td>아이디</td>
<td>
<input type="text" name="userid" id="userid">
</td>
</tr>
<tr>
<td>이름</td>
<td>
<input type="text" name="username" id="username">
</td>
</tr>

<tr>
<td>이메일</td>
<td>
<input type="email" name="email" id="email">
<select id="emailSelect">
<option>--이메일선택--</option>
<option value="naver.com">naver.com</option>
<option value="daum.net">daum.net</option>
<option value="gmail.com">gmail.com</option>
</select>
</td>
</tr>
</table>
<input type="submit" value="확인">
</form>
</div>




<div id="b" hidden="true">
<form action="MemberPW_phoneSearchServlet" method="post">
<table border='2'>
<tr>
<td>아이디</td>
<td>
<input type="text" name="userid" id="userid">
</td>
</tr>
<tr>
<td>이름</td>
<td>
<input type="text" name="username" id="username">
</td>
</tr>

<tr>
<td>휴대전화</td>
<td>
<select name="phone" id="phone1">
<option value="010">010</option>
<option value="011">011</option>
<option value="016">016</option>
</select>
-
<input type="text" name="phone" id="phone1">-
<input type="text" name="phone" id="phone2">
</td>
</tr>
</table>
<input type="submit" value="확인">
</form>
</div>
