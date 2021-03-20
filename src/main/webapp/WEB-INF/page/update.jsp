<%@page import="java.util.List"%>
<%@page import="org.omg.CORBA.Request"%>
<%@page import="com.jbk.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = (User) request.getAttribute("user");
	%>
	
	
	<center>
	<% List<User> userlist=(List<User>)request.getAttribute("list"); %>
		<h2>Update User</h2>
		<form action="edit" method="post">
			<table border="1">
				<tr>
					<td>Enter userName</td>
					<td><input type="text" name="userName"
						value="<%=user.getUserName()%>"></td>
				</tr>
				<tr>
					<td>Enter userEmail</td>
					<td><input type="text" name="userEmail"
						value="<%=user.getUserEmail()%>"></td>
				</tr>
				<tr>
					<td>Enter userPassword</td>
					<td><input type="password" name="userPassword"
						value="<%=user.getUserPassword()%>"></td>
				</tr>
				<tr>
					<td>Enter userContact</td>
					<td><input type="text" name="userContact"
						value="<%=user.getUserContact()%>"></td>
				</tr>
				<tr><td><input type="text" name="userId" readonly="readonly"
						value="<%=user.getUserId()%>"></td>
					<td><input type="submit" value="update"></td>
				</tr>


			</table>

		</form>
	</center>
</body>
</html>