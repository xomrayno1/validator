<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<c_rt:url value="/admin/xoa-san-pham" var="delete"></c_rt:url>

	<div id="rightContent">
	<h3>Product</h3>
	
	
		<table class="data">
			<tr class="data">
				<th class="data" width="30px">No</th>
				<th class="data">Tên Sản Phẩm </th>
				<th class="data">Giá tiền</th>
				<th class="data">Danh mục </th>
				<th class="data">Hình ảnh </th>
				<th class="data">Kiểu</th>

				<th class="data" width="75px">+</th>
			</tr>
			<c_rt:forEach items="${listproduct}" var="lp">
			<tr class="data">
				<td class="data" width="30px">${lp.idProduct}</td>
				<td class="data">${lp.nameProduct}</td>
				<td class="data">${lp.priceProduct}</td>
				<td class="data">${lp.idCategory}</td>
				<td class="data">${lp.imagesProduct}</td>
				<td class="data">${lp.typeProduct}</td>
				<td class="data" width="75px">
				<a href="${delete}?idproduct=${lp.idProduct}"><img src="../resource/images/oke.png"></a>
				<a href="#"><img src="../resource/images/detail.png"></a>
				
				</td>
			</tr>	
			</c_rt:forEach>
		
		
		</table>
		<p style="color: red">${mess}</p>
		<a href='<c_rt:url value="/admin/them-san-pham"></c_rt:url>'><input type="button" class="button" value="Thêm sản phẩm"></a>
	</div>
	<div class="clear"></div>