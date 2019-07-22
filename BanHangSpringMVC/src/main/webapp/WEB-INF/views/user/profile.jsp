<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



		
			<div align="center">
			
			<table border="1">
			<tr align="center">
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Địa Chỉ</th>
			<th>+</th>
			</tr>
			<tr>
			<td></td>
			<td>${profile.name} </td>
			<td> ${profile.sdt}  </td>
			<td>${profile.diachi}</td>
			<td><a href="sua-thong-tin?idprofile=${profile.idProfile}">Sữa</a> <a href="#">Xóa</a>  <a href="doi-mat-khau">EditPassword</a></td>
			</tr>
			</table>
			
			</div>
			
		
		
		
