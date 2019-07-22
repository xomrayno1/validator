<%@ page language="java" contentType="text/html; charset=utf-8"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c_rt"%>




			<div class="content">
				<div class="content-top">
				
					<h3 class="future">Xem Nhiều Nhất</h3>
					<div class="content-top-in">
			<c_rt:forEach var="product" items="${productview}">

					
					<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single?idProduct=${product.idProduct}&id=${product.idCategory}"><img  src="resource/${product.imagesProduct}" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single?idProduct=${product.idProduct}&id=${product.idCategory}">${product.nameProduct}</a></h5>
									<div class="white">
										<a href="single?idProduct=${product.idProduct}&id=${product.idCategory}" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>${product.priceProduct}</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
					
					
					</c_rt:forEach>


					
	
						
						
					<div class="clearfix"></div>
					</div>
				</div>
				<!---->
				<div class="content-middle">
					<h3 class="future">BRANDS</h3>
					<div class="content-middle-in">
					<ul id="flexiselDemo1">			
						<li><a href="https://www.apple.com/"><img src='<c:url value="/resource/images/ap.png"></c:url>'/></a>   </li>
						<li><a href="https://www.adidas.com/us"><img src='<c:url value="/resource/images/ap1.png"></c:url>'/></a>   </li>
						<li><a href="https://www.adidas.com/us"><img src='<c:url value="/resource/images/ap2.png"></c:url>'/></a>   </li>
						<li><a href="https://www.adidas.com/us"><img src='<c:url value="/resource/images/ap3.png"></c:url>'/></a>   </li>
					
					</ul>
            		<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src='<c:url value="resource/js/jquery.flexisel.js"></c:url>'></script>

					</div>
				</div>
				<!---->
				<div class="content-bottom">
					
					<div class="content-bottom-in">
					
					<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo2").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
					</div>
				</div>
				
				
				
			</div>
