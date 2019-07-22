<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c_rt:url value="/admin/addproduct" var="addproduct"> </c_rt:url>
	<div id="rightContent">
	<h3>Thêm Sản Phẩm</h3>
	
	<form:form modelAttribute="product" action="${addproduct}" method="POST" enctype="multipart/form-data">
	
	<table width="95%" >
			<tr><td width="125px"><b>Tên Sản Phẩm : </b></td><td><form:input path="nameProduct"/></td></tr>
			<tr><td><b>Giá Tiền :</b></td><td><form:input path="priceProduct"/></td></tr>
			<tr><td><b>Loại :</b></td><td>
				
				<form:radiobutton path="typeProduct" value="1"/>Điện Thoại
				<form:radiobutton path="typeProduct" value="2"/>Laptop && Máy tính bảng
			</td></tr>
			<tr><td><b>Tải lên :</b></td><td>			
		    <form:input path="multipartFile" type="file"/>
			<tr><td><b>Danh Mục</b></td><td>
			<form:select path="idCategory"  >
			<form:option value="1">Asus</form:option>
			<form:option value="2">Apple</form:option>
			<form:option value="3">Sony</form:option>
			<form:option value="4">LG</form:option>
			<form:option value="5">Xiaomi</form:option>
			<form:option value="6">Samsung</form:option>
	
			</form:select>
				
				
			</td></tr>
			<tr><td><b>Ghi chú : </b></td><td><form:textarea path="describeProduct"/>  </td></tr>
			<tr><td></td><td>
			<input type="submit" class="button" value="Thêm sản phẩm">
			<a href='<c_rt:url value="/admin/allproduct"></c_rt:url>'><input type="button" class="button" value="Tất cả sản phẩm"></a>
			<input type="reset" class="button" value="Ghi lại">
			<p style="color: red;">${mess}</p>
			</td></tr>
		</table>
	
	</form:form>

	
		
	</div>
		<div class="clear"></div>