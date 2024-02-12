<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>ADD USER DETAILS</h1>
		<spf:form action="/save" method="post" modelAttribute="user">
		UID: <input type="text" name="uid">
			</br>
			</br>
		USERNAME: <input type="text" name="username">
			</br>
			</br>
		CONTACT: <input type="text" name="contact">
			</br>
			</br>
		EMAIL: <input type="text" name="email">
			</br>
			</br>
		ADDRESS: <input type="text" name="addr">
			<input type="submit">

		</spf:form>
	</center>

</body>
</html>