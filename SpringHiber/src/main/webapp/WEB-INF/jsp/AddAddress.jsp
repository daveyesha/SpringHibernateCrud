<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />" />
<title>Insert title here</title>
</head>
<body>
<form method="post" action="insertAdd" class="form-group">
	<label>
		Enter Street
	</label>
	<input type="text" name="sid" value="${sid}" class="form-control"/>
	<input type="text" name="street" class="form-control"/>
	<label>Enter Landmark</label>
	<input type="text" name="landmark" class="form-control">
	<label>Enter Pincode</label>
	<input type="text" name="pincode" class="form-control">
	<input type="submit" value="insert" class="btn btn-primary">
</form>
<table class="table table-bordered">
    <tbody>
     <thead>
      <tr>
      	<th>ID</th>
      	<th>Student ID</th> 
      	<th>Street</th> 
      	<th>Landmark</th>
      	<th> Pincode</th>
      	<th> Action</th>
      </tr>
     </thead>
     <c:forEach items="${addressList}" var="address">
     	<tr>
     	<td>${address.id}</td>
     	<td>${address.sObj.id}</td>
     	<td>${address.street}</td>
     	<td>${address.landmark}</td>
     	<td>${address.pincode}</td>
     	<td><a href="DeleteAddress?aid=${address.id}&sid=${address.sObj.id}">Delete</a></td>
     </tr>
     </c:forEach>
     </table>
</body>
</html>