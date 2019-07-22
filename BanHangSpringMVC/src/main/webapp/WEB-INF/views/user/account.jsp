<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c_rt:url value="/dang-nhap" var="login"> </c_rt:url>

	<div class="container">
		<div class="account">
		
			<h2 class="account-in">Đăng Nhập</h2>
			
				<form:form action="${login}" method="POST" modelAttribute="user">
					<div>
					<span>Tài Khoản*</span>
					<form:input path="username"/>
				</div> 	
				<div> 
					<span class="word">Mật Khẩu*</span>
					<form:password path="password"/>
					<p style="color:red;"><form:errors path="password"/></p>
				</div>				
					<input type="submit" value="Login"> 
					<a href="dang-ki">Đăng Kí Nhanh?</a>
					
				
				</form:form>
				<hr>
				<c_rt:if test="${not empty mess}">
				<h3><a href="contact">Thanh Toán Nhanh</a></h3>
				
				</c_rt:if>

		</div>
	</div>