<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<table width="100%" cellspacing="0" cellpadding="0">

	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>

				<tr>
	<c:forEach var="x" items="${Goodslist}" varStatus="status">
		<c:if test="${status.index%3 == 0}">
		  <tr>
				        <td height="10">
				       </tr>
		  </c:if>
	<td>
							<td>
							<table style='padding:40px'>
								<tr>
									<td>
										<a href="SangseListServlet?gCode=${x.gCode}"> 
										<img src="images/items/${x.gImage}.gif" alt="Goods" width="247" height="347">
										</a>
									</td>
								</tr>
								<tr>
								
									<td height="10">
								</tr>
								<tr>
									<td class= "td_default" align ="center">
										<a class= "a_black" href=""> 
										${x.gName}<br>
										</a>
										<font color="gray">
										 --------------------
										</font>
									</td>
									
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_gray" align ="center">
										${x.gContent}
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align ="center"><font color="red"><strong>
									${x.gPrice}	</strong></font></td>
								</tr>
							</table>
						</td>

	</c:forEach>

			</table>
		</td>
	</tr>
	<tr>
		<td height="10" align="center">
<c:if test="${curPage != null}">
	<c:choose>
		<c:when test="${curPage ==1 }">
			맨처음
		</c:when>
		<c:otherwise>
			<a href="GoodsListServlet?curPage=${1 }&gcategory=${gcategory}">맨처음</a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${startPage==1 }">
			&lt;&lt;
		</c:when>
		<c:otherwise>
			<a href="GoodsListServlet?curPage=${startPage - 1 }&gcategory=${gcategory}">&lt;&lt;</a>
		</c:otherwise>
	</c:choose>
		
 	<c:choose>
 		<c:when test="${curPage==1 }">
 			&lt;
 		</c:when>
 		<c:otherwise>
 			<a href="GoodsListServlet?curPage=${curPage-1 }&gcategory=${gcategory}">&lt;</a>
 		</c:otherwise>
 	</c:choose>

			<c:forEach var="p" begin="${startPage}" end="${endPage }">

	<c:choose>
		<c:when test="${p==curPage}">
				${p}&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
			<a href="GoodsListServlet?curPage=${p}&gcategory=${gcategory}">${p}</a>
		</c:otherwise>
	</c:choose>	
	</c:forEach>
	
	<c:choose>
		<c:when test="${curPage == totalPage }">
			&gt;
		</c:when>
		<c:otherwise>
			<a href="GoodsListServlet?curPage=${curPage + 1 }&gcategory=${gcategory}">&gt;</a>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${endPage == totalPage }">
			&gt;&gt;
		</c:when>
		<c:otherwise>
			<a href="GoodsListServlet?curPage=${endPage + 1 }&gcategory=${gcategory}">&gt;&gt;</a>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${curPage == totalPage }">
			마지막
		</c:when>
		<c:otherwise>
			<a href="GoodsListServlet?curPage=${totalPage }&gcategory=${gcategory}">마지막</a>
		</c:otherwise>
	</c:choose>
</c:if>		
	</tr>
</table>
