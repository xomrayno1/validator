<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>


	<div id="rightContent">
	<h3>User</h3>
	
	
		<table class="data">
			<tr class="data">
				<th class="data" width="30px">No</th>
				<th class="data">Tên tài khoản </th>
				<th class="data">Mật khẩu</th>
				<th class="data">Role </th>
				<th class="data" width="75px">+</th>
			</tr>
			<c_rt:forEach items="${listuser}" var="ls">			
			<tr class="data">
				<td class="data" width="30px">1</td>
				<td class="data">${ls.username}</td>
				<td class="data">${ls.password}</td>
				<td class="data">${ls.role}</td>
				<td class="data" width="75px">
				
				<a href="#"><img src="../resource/images/oke.png"></a>
				<a href="#"><img src="../resource/images/detail.png"></a>
				
				</td>
			</tr>
			</c_rt:forEach>



			
		</table>
		<a href='<c_rt:url value="/admin/them-tai-khoan"></c_rt:url>'><input type="button" class="button" value="Thêm tài khoản"></a>
	</div>
	<div class="clear"></div>