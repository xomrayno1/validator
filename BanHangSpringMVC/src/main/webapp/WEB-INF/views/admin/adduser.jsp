<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c_rt:url value="/admin/adduser" var="adduser"> </c_rt:url>
	<div id="rightContent">
	<h3>Thêm Tài Khoản</h3>
	
	
	   <form:form action="${adduser}" method="POST" modelAttribute="userr">
	   
	       <table width="95%">
			<tr><td width="125px"><b>Tên Tài Khoản : </b></td><td><form:input path="username"/></td></tr>
			<tr><td width="125px"><b>Mật Khẩu  : </b></td><td><form:password path="password"/></td></tr>
			<tr><td><b>Vai Trò : </b></td><td>
				<form:radiobutton path="role" value="admin"/>Admin
				<form:radiobutton path="role" value="user"/>User
			</td></tr>
			<tr><td></td><td>
			<p style="color: red;">${mess}</p>
			<input type="submit" class="button" value="Thêm tài khoản">
			<a href='<c_rt:url value="/admin/alluser"></c_rt:url>'><input type="button" class="button" value="Tất cả tài khoản"></a>
			<input type="reset" class="button" value="Nhập lại">
			</td></tr>
		</table>
	   
	   </form:form>

	
		
	</div>
		<div class="clear"></div>