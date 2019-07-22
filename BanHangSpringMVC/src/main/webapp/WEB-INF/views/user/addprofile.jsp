<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c_rt:url var="addprofile" value="/them-thong-tin"></c_rt:url>
<div class="container">
		<div class="account">
			<h2 class="account-in">Thông Tin Khách Hàng</h2>
			<p>Vui Lòng Thêm Thông Tin Để Mua Hàng Được Tốt Hơn,Chi Tiết Liên Hệ :000000 </p>
				<form:form action="${addprofile}" method="POST" modelAttribute="profile">   
				<div>
					<span>Name*</span>
					<form:input path="name"/>
				</div> 	
				<div>			
					<span class="name-in">Phone*</span>
					<form:input path="sdt"/>
				</div>			
				<div> 	
					<span class="mail">ĐịaChỉ*</span>
					<form:input path="diachi"/>
				</div>
				    <form:hidden path="idUser" value="${sessionScope.user.idUser}"/>	
		
					<input type="submit" value="Thêm Thông Tin"> 
				 </form:form>
		</div>
	</div>