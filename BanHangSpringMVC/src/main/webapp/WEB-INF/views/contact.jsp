
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<c_rt:url value="/gui-mail" var="mail"/>

<div class="container">
			<div class="contact">
			<h2 class=" contact-in">CONTACT</h2>
				
				<div class="col-md-6 contact-top">
					<h3>Info</h3>
					<div class="map">
						<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d37494223.23909492!2d103!3d55!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x453c569a896724fb%3A0x1409fdf86611f613!2sRussia!5e0!3m2!1sen!2sin!4v1415776049771"></iframe>
					</div>
					
					<p>Địa Chỉ Shop</p>
				
					<ul class="social ">
						<li><span><i > </i>Việt Nam</span></li>
						<li><span><i class="down"> </i>+ 0332526777</span></li>
						<li><a href="mail.gooogle.com"><i class="mes"> </i>xomrayno1@gmail.com</a></li>
					</ul>
				</div>
				<div class="col-md-6 contact-top">

				<form:form modelAttribute="contact" action="${mail}" method="POST">
					<div>
							<span>Your Name </span>		
							<form:input path="yourName"/>					
						</div>
						<div>
							<span>SDT Mua Hàng </span>		
							<form:input path="SDT"/>						
						</div>
						<div>
							<span>Subject</span>		
							<form:input path="subject"/>		
						</div>
						<div>
							<span>Your Message</span>		
							<form:textarea path="yourMessage"/>			
						</div>
				
				<input type="submit" value="SEND" >	
				</form:form>		
						
						
						
						
						
				
				</div>
				<p style="color: red">${mess}</p>
			<div class="clearfix"> </div>
		</div>
	</div>