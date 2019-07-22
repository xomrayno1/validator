<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

		<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single">
					<div class="col-md-5 single-top">	
						<ul id="etalage">
							<li>
								<a href="#">
									<img class="etalage_thumb_image img-responsive" src="resource/${product.imagesProduct}" alt="" >
									
								</a>
							</li>
							
						   
						</ul>

					</div>	
					
					<div class="col-md-7 single-top-in">
						<div class="single-para">
							<h4>${product.nameProduct}</h4>
							<div class="para-grid">
								<span  class="add-to">$${product.priceProduct}</span>
								<form action="them-gio-hang1" method="get" id="form">

								<input type="submit" value="Add to Cart" class="hvr-shutter-in-vertical cart-to">
								<input type="hidden" value="${product.idProduct}" name="idproduct">
								
										
								<div class="clearfix"></div>
							 </div>
							<h5>100 items in stock</h5>
							<div class="available">
								<h6>Available Options :</h6>
								<ul>
								
								
									
								<li>Số Lượng:<select name="quantity" form="form">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select></li>
							  <p style="color: blue">Lượt Xem : ${view}</p>
								
								
							</ul>
							</form>	
						</div>
							<p>${product.describeProduct}</p>
							
								<a href="#" class="hvr-shutter-in-vertical ">More details</a>
							
						</div>
					</div>
					
				<div class="clearfix"> </div>
				
				<div class="content-top-in">
				
				<c:forEach items="${productview}" var="product">
				
			<div class="col-md-4 top-single">
							<div class="col-md">
								<a href="single?idProduct=${product.idProduct}&id=${product.idCategory}"><img  src="resource/${product.imagesProduct}" title="${product.nameProduct}"  /></a>
								<div class="top-content">
									<h5>${product.nameProduct}</h5>
									<div class="white">
										<a href="single?idProduct=${product.idProduct}&id=${product.idCategory}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>${product.priceProduct}</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
				</c:forEach>

						
					
						
					<div class="clearfix"></div>
					</div>
					
					
					
				</div>
				<div class="col-md-3">
					<div class="single-bottom">
						<h4>Categories</h4>
						<ul>
						
						<c:forEach items="${list}" var="l">
						
						<li><a href="getCategory1?id=${l.idCategory}"><i> </i>${l.nameCategory}</a></li>
						
						</c:forEach>
						
					


						</ul>
					</div>
					<div class="single-bottom">
						<h4>Product Categories</h4>
						<ul>
						<c:forEach items="${listProduct1}" var="l">  
						
						<li><a href="single?idProduct=${l.idProduct}&id=${l.idCategory}"><i> </i>${l.nameProduct}</a></li>
						
					     </c:forEach>
						</ul>
					</div>
				
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>