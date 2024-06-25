<%@page import="com.demo.model.user"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.demo.connection.myConnection"%><html>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width,initial-scale=1">
<style>
.pooja {
	float: right;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333333;
	text-decoration: none;
}
a
{
text-decoration: none;
}

li {
	float: left;
	margin-right: 10px;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111111;
}
</style>

</head>
<body>
	<ul>
		<li><a href="index.jsp">The Book Nook</a></li>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="addBook.jsp">Add Book</a></li>
		<li><a href="viewBook.jsp">View Book</a></li>
		<%
		user u = (user) session.getAttribute("user");
		if (u == null) {
		%>
		<div class="pooja">
			<li><a href="login.jsp" class="green">Login</a></li>
			<li><a href="register.jsp" class="red">Register</a></li>
		</div>

		<%
		} else {
		%><a href="logout" class="gray">Logout</a>
		</div>
		&nbsp&nbsp&nbsp
		<div class="blue"><%=u.getName()%></div>



		<%
		}
		%>
		</div>
	</ul>
</body>
</html>


