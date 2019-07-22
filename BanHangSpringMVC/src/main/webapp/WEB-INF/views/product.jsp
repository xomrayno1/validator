<%@ page language="java" contentType="text/html; charset=utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

		<div class="container">
			<div class="products">
			
					<h2 class=" products-in">PRODUCTS</h2>
					
		
					
					
					
					
					<c_rt:if test="${ not empty listProduct1}">
					<p>Bạn Có Muốn Xem Tất Cả Sản Phẩm Của :  <a href="getCategory1?id=${namecate.idCategory}">${namecate.nameCategory} </a></p>
					</c_rt:if>
					
					
					
					<div class=" top-products">
	
					<div class="clearfix"></div>
					</div>
				
					<div class="top-products">
					
						
						
					
					<c_rt:forEach items="${listProduct}" var="ld">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single?idProduct=${ld.idProduct}&id=${ld.idCategory}" class="compare-in"><img  src="resource/${ld.imagesProduct}" alt="" />
								<div class="compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>	
								</div>
								</a>	
								<div class="top-content">
									<h5><a href="single?idProduct=${ld.idProduct}&id=${ld.idCategory}">${ld.nameProduct}</a></h5>
									<div class="white">
										<a href="them-gio-hang?idproduct=${ld.idProduct}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>${ld.priceProduct}</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
					</c_rt:forEach>
   
					
					
					
					
					
					<div class="clearfix"></div>
					</div>
			</div>
			
			<ul class="start">
					<li ><a href="#"><i></i></a></li>
					
			<c_rt:forEach  begin="1" end="${coutPage}"   >
			<c_rt:set var="i" value="${i=i+1}"  />
					<li class="arrow"><a href="product?pageid=${i}">${i}</a></li>
			</c_rt:forEach>
					<li ><a href="#"><i  class="next"> </i></a></li>
				</ul>
			
		</div>