<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>


	<div id="rightContent">
	<h3>Chi tiết</h3>
	
	
		<table class="data">
			<tr class="data">
				<th class="data" width="30px">No</th>
				<th class="data">Tên Sản Phẩm </th>
				<th class="data">Giá tiền x1 </th>
				<th class="data">Danh mục </th>
				<th class="data">Hình ảnh </th>
	

				<th class="data" width="75px">+</th>
			</tr>
			
			<tr class="data">
				<td class="data" width="30px">${product.idProduct}</td>
				<td class="data">${product.nameProduct}</td>
				<td class="data">${product.priceProduct}</td>
				<td class="data">${product.idCategory}</td>
				<td class="data">${product.imagesProduct}</td>

				<td class="data" width="75px">
				
				</td>
			</tr>	
			
		
		
			
		</table>
	</div>
	<div class="clear"></div>