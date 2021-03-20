<%@page import="com.jbk.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Project</title>
</head>
<body>
	<center>
	<% List<User> userlist=(List<User>)request.getAttribute("list"); %>
		<%
			String msg = (String) request.getAttribute("msg");
		%>>
		<h1>Login Here</h1>
		<%
			if (msg != null) {
		%>
		<%
			out.println(msg);
		%>
		<%
			}
		%>

		<form action="login" method="post">
			<table border="1">
				<tr>
					<td>Enter User name</td>
					<td><input type="text" name="userEmail"></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="userPassword"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="login"></td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>