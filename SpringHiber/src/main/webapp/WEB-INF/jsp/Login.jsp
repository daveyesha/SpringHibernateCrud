<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
<title>Spring Hibernate</title>
</head>
<body>
<form method="post" action="index" class="form-group">
	<label>
		Enter Username
	</label>
	<input type="text" name="userName" class="form-control"/>
	<label>Enter Password</label>
	<input type="password" name="pass" class="form-control">
	<input type="radio" value="Admin" name="role" >Admin
	<input type="radio" value="Student" name="role">Student</br>
	<input type="submit" value="Login" class="btn btn-primary">
</form>
</body>
</html>