<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c_rt"%>

<%@   taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Admin MOS Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Copyright" content="arirusmanto.com">
<meta name="description" content="Admin MOS Template">
<meta name="keywords" content="Admin Page">
<meta name="author" content="Ari Rusmanto">
<meta name="language" content="Bahasa Indonesia">

<link rel="shortcut icon" href="stylesheet/img/devil-icon.png"> <!--Pemanggilan gambar favicon-->
<link rel="stylesheet" type="text/css" href="../resource/css/mos-style.css"> <!--pemanggilan file css-->

<c_rt:url var="url" value="/admin/dang-nhap"></c_rt:url>
</head>

<body>
<div id="header">
	<div class="inHeaderLogin"></div>
</div>
<div id="loginForm">
	<div class="headLoginForm">
	Login Administrator
	</div>
	<div class="fieldLogin">
		
	
	
	<form:form modelAttribute="user" action="${url}" method="POST">
	Username :<form:input path="username"/>
	Password :<form:password path="password"/>
	<input type="submit" class="button" value="login">
	</form:form>
	
	
	
	</div>
</div>



</body>
</html>