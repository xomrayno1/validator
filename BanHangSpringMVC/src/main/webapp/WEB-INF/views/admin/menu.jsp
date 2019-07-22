<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c_rt"%>

	<div id="leftBar">
	<ul>
		<li><a href='<c_rt:url value="/admin/index"></c_rt:url>'>Dashboard</a></li>
		<li><a href='<c_rt:url value="/admin/alluser"></c_rt:url>'>AllUser</a></li>
		<li><a href='<c_rt:url value="/admin/allproduct"></c_rt:url>'>AllProduct</a></li>		
		<li><a href='<c_rt:url value="/admin/them-tai-khoan"></c_rt:url>'>AddUser</a></li>
		<li><a href='<c_rt:url value="/admin/them-san-pham"></c_rt:url>'>AddProduct</a></li>
		<li><a href='<c_rt:url value="/admin/bill"></c_rt:url>'>get Bill</a></li>
	</ul>
	</div>