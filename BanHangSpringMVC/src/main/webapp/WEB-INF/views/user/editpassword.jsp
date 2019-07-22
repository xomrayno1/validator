<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c_rt:url value="/edit" var="edit"> </c_rt:url>

	<div class="container">
		<div class="account">
			<h2 class="account-in">Đổi Mật Khẩu</h2>
			
			<p style="color: red;">${mess}</p>
				<form action="${edit}" method="POST">
				
	
				<div> 
					<span class="word">Mật Khẩu Mới*</span>
					<input type="password" name="newpassword">	
				</div>
				<div> 
					<span class="word">Nhập Lại Mật Khẩu*</span>
					<input type="password" name="reppassword">	
				
				</div>				
					<input type="submit" value="Đổi Mật Khẩu"> 
				</form>
				 	
				
				
		

		</div>
	</div>
	
	