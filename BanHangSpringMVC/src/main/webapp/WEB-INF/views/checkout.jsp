<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


	<div class="container">
	
	<p style="color: red">${mess}</p>
		<div class="check-out">
    	    <c:if test="${empty sessionScope.listcartitem}">
    	    <h4 class="title">Shopping cart is empty</h4>
    	    <p class="cart">You have no items in your shopping cart.<br>Click<a href="trang-chu"> here</a> to continue shopping</p>
    	    </c:if>
    	  
    <c:forEach items="${sessionScope.listcartitem}" var="listcart">
    
    <p><img alt="" src="resource/${listcart.product.imagesProduct}"> <a href="single?idProduct=${listcart.product.idProduct}&id=${listcart.product.idCategory}">Chi Tiết</a>  Giá Tiền : ${listcart.product.priceProduct} Quantity :${listcart.quantity} UnitPrice :${listcart.unitPrice}</p>
    <c:set var="total" value="${total + listcart.unitPrice}"  />
    
    </c:forEach>
    
    	 <c:if test="${not empty sessionScope.listcartitem}">
    	   <p> Tổng Giá Tiền :${total}  </p>
    	   <a href="order?total=${total}"><button>Thanh Toán</button></a>
         </c:if>   
    	

   
    	</div>
    	
    	

	</div>