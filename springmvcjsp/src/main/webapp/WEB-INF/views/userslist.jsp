<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,tr,th,td {
	border: 1px solid;
}

</style>
</head>
<body>

	<center>
		<h1>USER DETAILS</h1>
		<button ><a href="/adduser">ADD USER</a></button>
		<table>
			<tr>
				<th>UID</th>
				<th>USERNAME</th>
				<th>CONTACT</th>
				<th>EMAIL</th>
				<th>ADDRESS</th>
			</tr>
			<c:forEach items="${usr}" var="user">
				<tr>
					<td>${user.uid}</td>
					<td>${user.username}</td>
					<td>${user.contact}</td>
					<td>${user.email}</td>
					<td>${user.addr}</td>
				</tr>
			</c:forEach>
		</table>

	</center>
</body>
</html>