
<%@page import="com.demo.model.book"%>
<%@page import="com.demo.dao.bookDao"%>
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
<style>
table {
	margin-left: auto;
	margin-right: auto;
	background: #fff;
}
</style>
</head>
<body style="background-color: #f7e1f2">
	<%@include file="navbar.jsp"%>

	<%
	if (u == null) {
		session.setAttribute("invalidMsg", "Please Login...");
		response.sendRedirect("login.jsp");
			}
	%>

	<center>
		<h4 style="font-size: 60px;">Edit Book</h4>
		<%
		String failedMsg = (String) session.getAttribute("failedMsg");
				if (failedMsg != null) {
		%>
		<p><%=failedMsg%></p>
		<%
		session.removeAttribute("failedMsg");
				}
		%>
		<form action="edit" method="post">
			<%
			int cid = Integer.parseInt(request.getParameter("cid"));
									bookDao cd = new bookDao(myConnection.getConnection());
									book c = cd.getBookById(cid);
			%><table border="1">

				<tr>
					<td><input type="hidden" value="<%=cid%>" name="cid"></td>
				</tr>
				<tr>
					<td>Title:<input value="<%=c.getTitle()%>" name="title"
						type="text">
					</td>
				</tr>
				<tr>
					<td>Author's Name:<input value="<%=c.getAuthorName()%>"
						name="authorName" type="text">
					</td>
				</tr>
				<tr>
					<td>Publisher's Name:<input value="<%=c.getPublisher()%>"
						name="publisher" type="text">
					</td>
				</tr>
				<tr>
					<td>Description Of Book: <textarea rows="3" cols="35"
							placeholder="Enter Description" name="description"><%=c.getDescription()%>
</textarea></td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="Update">
					</td>
				</tr>
			</table>
			</div>
		</form>
	</center>
</body>
</html>