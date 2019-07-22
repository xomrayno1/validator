<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="trang-chu"><img src='<c:url value="resource/images/tam2.jpg"></c:url>' alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							
							
							<c_rt:if test="${empty sessionScope.user}">
							<li  ><a href='<c:url value="login"></c:url>'>ĐĂNG NHẬP</a></li>
							</c_rt:if>
							
							<c_rt:if test="${not empty sessionScope.user}">
							<li  ><a href="logout">ThoátĐăngNhập</a></li>
								<li  ><a href="thong-tin-chi-tiet?iduser=${sessionScope.user.idUser}">Chào,${sessionScope.user.username} </a></li>
							</c_rt:if>
						
							<li ><a href="#" > SHOPPING CART</a></li>
							<li > <a href="checkout" >CHECKOUT</a> </li>	
							<li><div class="cart">
									<a href="#" class="cart-in"> </a>
									<span>${fn:length(listcartitem)}</span>
								</div>
								<ul class="sub-icon1 list">
						  <h3> Cart : ${fn:length(listcartitem)} </h3>
						  
						  <div class="shopping_cart">
						  
						  
						
							  <c_rt:forEach items="${sessionScope.listcartitem}" var="listcart">	  
							  <div class="cart_box">
							   	 <div class="message">
							   	     <div class="alert-close"><a href="closecart?idproduct=${listcart.product.idProduct}"></a></div>
					                <div class="list_img"><img src="resource/${listcart.product.imagesProduct}" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">${listcart.product.nameProduct}</a></h4>${listcart.quantity}x<span class="actual">
		                             $${listcart.product.priceProduct}</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                            
	                             <c_rt:set var="total" value="${total + listcart.unitPrice}"/>
							  </c_rt:forEach>
						
	                            
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">CartSubtotal : </div>
	                        	<div class="total_right">$${total}</div>
	                        	<div class="clearfix"> </div>
	                        </div>
                            <div class="login_buttons">
							  <div class="check_button"><a href="checkout">Check out</a></div>
							  <div class="clearfix"></div>
						    </div>
					      <div class="clearfix"></div>
						</ul>
							</li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="trang-chu"><i> </i>Desktops</a></li>
					
					<li ><a href="#" >Phone</a>
					
					<ul class="drop">
					<c_rt:forEach items="${list}" var="l">					
							<li><a href="getCategory?id=${l.idCategory}&idtype=1">${l.nameCategory}</a></li>	
					</c_rt:forEach>
					</ul>
					 </li> 
						
												
						<li><a href="#">  Laptop && Tablets</a>
						<ul class="drop">
					<c_rt:forEach items="${list}" var="l">					
							<li><a href="getCategory?id=${l.idCategory}&idtype=2">${l.nameCategory}</a></li>	
					</c_rt:forEach>
					</ul>
						</li>    
						
						<li><a href="product?pageid=1">Tất Cả Sản Phẩm</a></li>
						
						<li><a href="contact">  Contact</a></li>

				 
					
				</ul>
				<script type="text/javascript" src='<c:url value="/resource/js/nav.js"/>'></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
			<div class="container">
			<div class="header-bottom-on">
			<p class="wel"><a href="login">Xin chào bạn, mời bạn đăng nhập để mua hàng</a></p>
			<div class="header-can">
				<ul class="social-in">
						<li><a href="#"><i> </i></a></li>
						<li><a href="https://www.facebook.com/CHUBUXR"><i class="facebook"> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>					
						<li><a href="#"><i class="skype"> </i></a></li>
					</ul>	
					<div class="down-top">		
							<select class="in-drop">
							  <option value="Dollars" class="in-of">Dollars</option>
							  <option value="Euro" class="in-of">Euro</option>
							  <option value="Yen" class="in-of">Yen</option>
							</select>
					 </div>
					 
					<div class="search">
						<form method="get" action="tim-kiem">
							<input type="text" value="Search" placeholder="tìm kiếm" name="nameproduct"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}"  >
							<input type="submit" value="">
						</form>
					</div>

					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>