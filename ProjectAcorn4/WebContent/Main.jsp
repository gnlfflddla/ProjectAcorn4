<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<c:set var="mesg" value="${mesg}" scope="session"/>	
<c:if test="${empty mesg==false }">
<script type="text/javascript">
	alert('${mesg}');
</script>	
	</c:if>
	<c:remove var="mesg"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    
<link rel="stylesheet" type="text/css" href="css/css.css">
<link rel="stylesheet" type="text/css" href="css/slide.css">



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#main").on("click", function(){
			location.href="Main";
		});
	});
	

	
	
</script>


</head>

<body>


	<div align=right>
	<jsp:include page="common/top.jsp"></jsp:include></div>
	
		<div align="center">
	<a href="MainP">
	<img alt="daemoon" src="images/dae.jpg">
	</a>
	</div>
	
	<jsp:include page="common/menu.jsp"></jsp:include>
<div class="slideshow-container" >   <!-- style="position: static" -->

	<div class="center">
<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="images/img_nature_wide.jpg" style="width:100%">
  <div class="text">신상품1</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="images/img_snow_wide.jpg" style="width:100%">
  <div class="text">신상품2</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="images/img_mountains_wide.jpg" style="width:100%">
  <div class="text">신상품3</div>
</div>
	</div>
<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>

<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>



<jsp:include page="Goods/Goods.jsp"></jsp:include>







</body>
</html>