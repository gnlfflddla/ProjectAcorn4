<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	// 상품 색상 추가
	var n=0;
	$("#AddcBtn").on("click",function(event){
		event.preventDefault();
		if(n<6){
		$("#color").after("<tr class='colors'><td>상품 색상 : <input type='text' name='pColor' class='colors2'></td></tr>");
		n++;
		}else{
			alert("색상은 5개만 추가 가능합니다.");
		}
	});
	
	// 상품 삭제
	$("#DelcBtn").on("click",function(event){
		event.preventDefault();
		$(".colors").first().remove();
		if(n>0){
		n--;
		}else if(n==0){
			alert("하나의 상품 색상은 필수 입니다..")
		}
	});
	
	// color 중복체크
 	var eq="";
	var eq2=0;
	$("form").submit(function(event){
		$(".colors2").each(function(idx,ele){
			if(eq==$(ele).val()){
				eq2=1;
			}
			eq = $(ele).val();
		});
		if(eq2==1){
			event.preventDefault();
			alert("중복된 색상이 있습니다.");
			eq2=0;
		}else{
			$("form").submit();
		}
	}); 
	
	// 상품 이미지 추가
	var j=0;
	$("#AddiBtn").on("click",function(event){
		event.preventDefault();
		if(j<2){
		$("#image").after("<tr class='images'><td>상품 이미지 : <input type='file' name='pImage'></td></tr>");
		j++;
		}else{
			alert("이미지는 3개만 추가 가능합니다.");
		}
	});
	
	// 이미지 삭제
	$("#DeliBtn").on("click",function(event){
		event.preventDefault();
		$(".images").first().remove();
		if(j>0){
		 j--;
		}else if(j==0){
			alert("하나의 상품 이미지는 필수 입니다.");
		}
	});
	
});
</script>
</head>
<h1 align="center">상품 등록</h1>
<hr>
<body>
 <form action="../ProductAddServlet" method="POST" enctype="multipart/form-data">
<table align="center">
<tr> 
 <td>상품 코드 : <input type="text" name="pCode"></td>
</tr>
<tr id="image">
 <td> 상품 이미지 : <input type="file" name="pImage">
 	  <input type="button" value="이미지 추가" id="AddiBtn"> 
 	  <input type="button" value="이미지 삭제" id="DeliBtn"> 
 </td>
</tr>
<tr>
 <td>상품명 : <input type="text" name="pName"></td>
</tr>
<tr>
 <td>상품 내용 : <input type="text" name="pContent"></td>
</tr>
<tr>
 <td>상품 종류 : 
 <input type="checkbox" name="pCategory" value="top">Top
 <input type="checkbox" name="pCategory" value="dress">Dress
 <input type="checkbox" name="pCategory" value="outer">Outer
 <input type="checkbox" name="pCategory" value="bottom">Bottom
 </td>
</tr>
<tr id="color">
<td> 상품 색상 : <input type="text" class="colors2" name="pColor"> 
     <input type="button" value="색상 추가" id="AddcBtn">
     <input type="button" value="색상 삭제" id="DelcBtn">	 
</td>
<tr>
 <td>상품 사이즈 : 
 <input type="checkbox" name="pSize" value="L">L
 <input type="checkbox" name="pSize" value="M">M
 <input type="checkbox" name="pSize" value="S">S
 <input type="checkbox" name="pSize" value="FREE">FREE
 </td>
</tr>

<tr>
 <td>가격 : <input type="text" name="pPrice"></td>
</tr>
<tr>
 <td colspan="2" align="center">
 <input type="submit" value="상품등록">
 <input type="reset" value="등록취소">
 </td>
</tr>
</table>
 </form>
</body>
</html>