<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c_rt:url var="register" value="/register" />
	<div class="container">
		<div class="account">
			<h2 class="account-in">Đăng Kí</h2>
					
			<form:form action="${register}" method="POST" modelAttribute="user">
			
				<div>
					<span>Tài Khoản*</span>
					<form:input path="username"/>
					
				</div> 	
				<div> 
					<span class="word">Mật Khẩu*</span>
					<form:password path="password"/>
					<form:hidden path="role" value="user"/>
					<p style="color: red"><form:errors  path="password"/></p>
				</div>					
					<input type="submit" value="Đăng Kí"> 
					
					<a href="login">Đã có tài khoản?</a>
			
			</form:form>	
				
		</div>
	</div>