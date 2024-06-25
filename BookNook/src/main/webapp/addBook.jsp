
<%@page import="java.util.List"%>
<%@page import="com.demo.connection.myConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>  <meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<style type="text/css">
table {
	margin-left: auto;
	margin-right: auto;
	background: #fff;
}
</style>
</head>
<body style="background-color: #faf0d4">
	<center>
		<%@include file="navbar.jsp"%>
		<%
	if (u == null) {
		session.setAttribute("invalidMsg", "Please Login...");
		response.sendRedirect("login.jsp");
	}
	%>

		<h4 style="font-size: 60px;">Add Book</h4>
		<%
		String successMsg = (String) session.getAttribute("successMsg");
		String failedMsg = (String) session.getAttribute("failedMsg");
		if (successMsg != null) {
		%>
		<p><%=successMsg%></p>
		<%
		session.removeAttribute("successMsg");
		}
		if (failedMsg != null) {
		%>
		<p><%=failedMsg%></p>
		<%
		session.removeAttribute("failedMsg");
		}
		%>
		<form action="addBook" method="post">

			<table border="1">

				<%
					if (u != null) {
					%>
				<input type="hidden" value="<%=u.getId()%>" name="userId">
				<%
					}
					%>
				<tr>
					<td>Author's Name:<input name="title" type="text"></td>
				</tr>
				<tr>
					<td>Name Of The Author:<input name="authorName" type="text"></td>
				</tr>
				<tr>
					<td>Name Of The Publisher:<input name="publisher" type="text"></td>
				</tr>
				<tr>
					<td>Description:<textarea rows="3" cols="35"
							placeholder="Enter About" name="description"></textarea></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Save Book"></td>
				</tr>

				</form>
			</table>
	</center>
</body>
</html>