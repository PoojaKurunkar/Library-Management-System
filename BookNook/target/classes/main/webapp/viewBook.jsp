
<%@page import="com.demo.model.book"%>
<%@page import="com.demo.dao.bookDao"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.connection.myConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css">
<style type="text/css">
.table, td {
	border: 1px solid black;
	padding: 15px;
}

}
table {
	border-spacing: 20px;
	padding: 15px;
	border: 1px solid black;
}
</style>
</head>
<body style="background-color: #e3dded">
	<center>
		<%@include file="navbar.jsp"%>
		<%
		if (u == null) {
			session.setAttribute("invalidMsg", "Please Login...");
			response.sendRedirect("login.jsp");
		}
		%>
		<%
		String successMsg = (String) session.getAttribute("successMsg");
		String failedMsg = (String) session.getAttribute("failedMsg");
		if (successMsg != null) {
		%><%=successMsg%>
		<%
		session.removeAttribute("successMsg");
		}
		if (failedMsg != null) {
		%>
		<p><%=failedMsg%></p>
		<%
		session.removeAttribute("failedMsg");
		}
		%><table>
			<%
			if (u != null) {
				bookDao cd = new bookDao(myConnection.getConnection());
				List<book> list = cd.getAllBook(u.getId());
				int count = 0;
				for (book c : list) {

					if (count % 3 == 0) {
			%><tr>
				<%
				}
				count++;
				%><td>Name:<%=c.getTitle()%><br> Phone No:<%=c.getAuthorName()%><br>

					Email : <%=c.getPublisher()%><br> About : <%=c.getDescription()%><br>

					<a href="edit.jsp?cid=<%=c.getId()%>">Edit</a>&nbsp&nbsp<a
					href="delete?cid=<%=c.getId()%>">Delete</a> <br>
				</td>
				<%
				}
				}
				%>
			
			<tr>
		</table>
	</center>
</body>
</html>