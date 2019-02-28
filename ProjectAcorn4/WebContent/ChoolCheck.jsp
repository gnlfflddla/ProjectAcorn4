<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>	
/* 	$(document).ready(function(){
		
	
	$("button").on("click",function(){
	   		 var date = new Date;
	   		 
	   		 console.log(date);
 	     $.ajax({
	    		type : "GET",
				url : "ChoolCheck",
				dataType : "text",
				data : {
					date : date,
				},
				success : function(responseData, status, xhr) {
					var mesg = "${mesg}"
				     alert(mesg);
				},
				error : function(xhr, status, error) {
					console.log("error");
				}
	   	 }); 
	     });	
	}); */

	</script>

</head>
<body>
<form action="ChoolCheck">
 <button>출석체크</button>

</form>
</body>
</html>