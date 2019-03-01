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
   
	<form:form action="student" method="POST" commandName="student" modelAttribute="student">
	<div class="form-group">
		
		    <label>First Name</label>
		    <form:input path="sFirstName" class="form-control" ></form:input>
	  	</div>
	  	<div class="form-group">
		    <label>Last Name</label>
		    <form:input path="sLastName" class="form-control"></form:input>
	  	</div>
	  	<div class="form-group">
		    <label>Enrollment</label>
		    <form:input path="sEnroll" class="form-control"></form:input>
	  	</div>
	  	<div class="form-group">
		    <label>City</label>
		    <form:input path="sAdd" class="form-control"></form:input>
	  	</div>		
		  <div class="form-group">
		    <label>Email address</label>
		   <form:input path="sEmail" class="form-control"></form:input>
		    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
		  </div>
		  <div class="form-group">
		    <label>Password</label>
		    <form:input path="sPassword" class="form-control"></form:input>
		  </div>
		  <button type="submit" value="a" name="action" class="btn btn-primary">Add</button>
	</form:form>
	<br><br>
	<table class="table table-bordered">
    <tbody>
     <thead>
      <tr>
      	<th>ID</th> 
      	<th>Firstname</th> 
      	<th>Lastname</th>
      	<th> Enrollment</th>
      	<th> City </th>
      	<th>Email</th>
      	
      </tr>
     </thead>
     <c:forEach items="${studentList}" var="student">
     	<tr>
     	<td>${student.id}</td>
     	<td>${student.sFirstName}</td>
     	<td>${student.sLastName}</td>
     	<td>${student.sEnroll}</td>
     	<td>${student.sAdd}</td>
     	<td>${student.sEmail}</td>
     	<td>${student.sPassword}</td>
     	<td><a href="indexAfterEdit?id=${student.id}">Edit</a></td>
     	<td><a href="delete?id=${student.id}">Delete</a></td>
     	<td><a href="addAddress?id=${student.id}">Add Address</a></td>
     </tr>
     </c:forEach>
     </table>
</body>
</html>