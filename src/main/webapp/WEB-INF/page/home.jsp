<%@page import="com.jbk.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<% String msg=(String)request.getAttribute("msg"); %>
	<% List<User> userlist=(List<User>)request.getAttribute("list"); %>
<h1>Welcome to Home</h1>
<% if(msg!=null){%>
<h3><% out.println(msg); %></h3>
<%} %>

<table border="1">
<tr>
<th>User Id</th>
<th>UserName</th>
<th>User Email</th>
<th>User contact</th>
<th>Delete</th>
<th>Update</th>
</tr>
<% for(User user:userlist){ %>
<tr>
<td><%out.println(user.getUserId()); %></td>
<td><% out.println(user.getUserName()); %></td>
<td><%out.println(user.getUserEmail()); %></td>
<td><%out.println(user.getUserContact()); %></td>
<td><a href="delete?id=<%=user.getUserId() %>">Delete</a></td>
<td><a href="update?id=<%=user.getUserId() %>">Update</a></td>
</tr>
<%} %>
<tr>
<td><a href="Register"></a></td> >
</tr>


</table>
</center>
</body>
</html>