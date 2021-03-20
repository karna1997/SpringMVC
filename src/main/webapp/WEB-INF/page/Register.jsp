<%@page import="com.jbk.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<%
		User user = (User) request.getAttribute("user");
	%>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (msg != null) {
	%>
	<h2>
		<%
			out.println(msg);
		%>
	</h2>
	<%
		}
	%>
	<form action="save" method="post">
		<table border="1">

			<tr>
				<td>Enter name</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><input type="text" name="userEmail"></td>
			</tr>
			<tr>
				<td>Enter password</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
			<tr>
				<td>Enter contact</td>
				<td><input type="text" name="userContact"></td>
			</tr>
			<tr>
			
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>

		</table>
	</form>


</body>
</html>