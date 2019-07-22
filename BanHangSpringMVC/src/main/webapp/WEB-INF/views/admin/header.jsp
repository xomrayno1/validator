<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


	<div id="header">
	<div class="inHeader">
		<div class="mosAdmin">
		Hello, ${user.username} Administrator<br>
		 <a href="">Help</a>   
		 <c:if test="${not empty user }"> | <a href='<c:url value="/admin/logout"></c:url>'>Thoát đăng nhập</a> </c:if>
		</div>
	<div class="clear"></div>
	</div>
</div>