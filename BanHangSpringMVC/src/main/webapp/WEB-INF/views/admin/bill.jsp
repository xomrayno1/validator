<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<c_rt:url value="/admin/bill-chi-tiet" var="chitiet"></c_rt:url>
<c_rt:url value="/admin/xoa-bill" var="delete"></c_rt:url>
	<div id="rightContent">
	<h3>Bill</h3>
	
	
		<table class="data">
			<tr class="data">
				<th class="data" width="30px">idOrder</th>
				<th class="data">UserName </th>
				<th class="data">Tên Order </th>
				<th class="data">Id Sản Phẩm</th>
				<th class="data">Địa Chỉ</th>
				<th class="data">SDT </th>
				<th class="data">Số Lượng </th>
				<th class="data">Giá x Số Lượng</th>
				<th class="data">Thời Gian Order</th>

				<th class="data" width="75px">+</th>
			</tr>
			<c_rt:forEach items="${bill}" var="lp">
			<tr class="data">
				<td class="data" width="30px">${lp.idorder}</td>
				<td class="data">${lp.username}</td>
				<td class="data">${lp.name}</td>
				<td class="data">${lp.idproduct}</td>
				<td class="data">${lp.diachi}</td>
				<td class="data">${lp.sdt}</td>
				<td class="data">${lp.quantity}</td>
				<td class="data">${lp.unitPrice}</td>
				<td class="data">${lp.dateOrder}</td>
				<td class="data" width="75px">
				<a href="${delete}?idorder=${lp.idorder}"><img src="../resource/images/oke.png" title="chấp nhận"></a>
				<a href="${chitiet}?idproduct=${lp.idproduct}"><img src="../resource/images/detail.png" title="chi tiết"></a>
				
				</td>
			</tr>	
			</c_rt:forEach>
		   <p style="color: red">${mess}</p>
		
			
		</table>
	</div>
	<div class="clear"></div>